package deadlock;

import raceCondition.AsynchronizedVersion.Bank;

public class UnsynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final double DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for(int i = 0; i < NACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () -> {
              try {
                  while(true){
                      int toAccount = (int)(bank.size() * Math.random());
                      double amount = 2 * MAX_AMOUNT * Math.random();   //修改每次交易的金额上限，观察是否会出现死锁
                      bank.transfer(fromAccount,toAccount,amount);
                      Thread.sleep((int)(DELAY * Math.random()));
                  }
              }catch (InterruptedException e){

              }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
