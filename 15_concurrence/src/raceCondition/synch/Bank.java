package raceCondition.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;  //conditional variable
    /**
     *
     * @param n                 账户的数量
     * @param initialBalance    每个账户的初始金额
     */

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds =  bankLock.newCondition();
    }

    /**
     *
     * @param from      转出账户
     * @param to        转入账户
     * @param amount    金额
     */

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            /*
                如果不使用这个条件对象的话会出现账户里面数值为负的情况，这显然是错误的
             */
            while(accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            System.out.print("accounts[from] = " + accounts[from] + "\t\t");
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d\t\t", amount, from, to);
            accounts[to] += amount;
            System.out.print("accounts[to] = " + accounts[to] + "\t\t");
            System.out.printf(" Total Balance: %10.2f%n\t\t",getTotalBalance());
            /*
                注意这个必须和await配套使用,否则会出现死锁
                死锁的具体原因还要仔细分析
             */
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
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
