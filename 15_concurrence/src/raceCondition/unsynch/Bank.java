package raceCondition.unsynch;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    /**
     *
     * @param n                 账户的数量
     * @param initialBalance    每个账户的初始金额
     */

    public Bank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /**
     *
     * @param from      转出账户
     * @param to        转入账户
     * @param amount    金额
     */

    public void transfer(int from, int to, double amount){
        if(accounts[from] < amount) return ;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n",getTotalBalance());
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
