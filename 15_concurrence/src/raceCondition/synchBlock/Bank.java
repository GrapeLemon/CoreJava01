package raceCondition.synchBlock;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;
    private Object lock = new Object();
    /**
     *
     * @param n                 账户的数量
     * @param initialBalance    每个账户的初始金额
     */

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /**
     *
     * @param from      转出账户
     * @param to        转入账户
     * @param amount    金额
     */
    @Deprecated
    public void transfer(int from, int to, double amount) throws InterruptedException {
       synchronized (lock){
           try {
           /*
                这个版本是有问题的，竟然能转出比自己账户里面多的钱，很显然在这里这个wait不起作用，不能这样写
            */
               while(accounts[from] < amount)
                   lock.wait();
               System.out.print(Thread.currentThread());
               accounts[from] -= amount;
               System.out.print("accounts[from] = " + accounts[from] + "\t\t");
               System.out.printf("%10.2f from %d to %d\t\t", amount, from, to);
               accounts[to] += amount;
               System.out.print("accounts[to] = " + accounts[to] + "\t\t");
               System.out.printf(" Total Balance: %10.2f%n\t\t",getTotalBalance());
            /*
                注意这个必须和await配套使用,否则会出现死锁
                死锁的具体原因还要仔细分析
             */
               lock.notifyAll();
           } finally {
           }
       }
    }

    /**
     *  对银行内所有账户的余额求和
     * @return  银行总额
     */

    public double getTotalBalance(){
        double sum = 0;
        for(double a : accounts)
            sum += a;
        return sum;
    }

    /**
     *  获得银行账户的数量
     * @return  银行账户的数量
     */

    public int size(){
        return accounts.length;
    }
}
