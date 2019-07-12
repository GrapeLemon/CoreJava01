package raceCondition.synchronizedVersion;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;
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

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while(accounts[from] < amount)
            wait();
        System.out.print(Thread.currentThread());
        System.out.print("accounts[from] = " + accounts[from] + "\t\t");
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d\t\t", amount, from, to);
        accounts[to] += amount;
        System.out.print("accounts[to] = " + accounts[to] + "\t\t");
        System.out.printf(" Total Balance: %10.2f%n\t\t",getTotalBalance());
        notifyAll();
    }

    /**
     *  对银行内所有账户的余额求和
     * @return  银行总额
     */

    public synchronized double getTotalBalance(){       //这里不加synchronized好像也没什么影响？？
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
