package threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadLocal {
    public static final AtomicInteger count = new AtomicInteger(0);

    public synchronized  static void print(){
        System.out.println("count = " + count.incrementAndGet() +  " " + Thread.currentThread());

    }


    public static void main(String[] args) {
        NoUseThreadLocal noUseThreadLocal = new NoUseThreadLocal();
        for (int i = 0; i < 2; i++) {
            Runnable r = () -> {
                try{
                    while(true){
                        print();
                        Thread.sleep(1000);
                    }
                }catch (Exception e){

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
