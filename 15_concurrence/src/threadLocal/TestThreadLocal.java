package threadLocal;

import java.util.LinkedList;

public class TestThreadLocal {
    public static final double DELAY = 10;
    LinkedList linkedList;
    public static void main(String[] args) {
        NoUseThreadLocal noUseThreadLocal = new NoUseThreadLocal();
        for (int i = 0; i < 2; i++) {
            Runnable r = () -> {
                try{
                    while(true){
                        noUseThreadLocal.printDate();
                    }
                }catch (Exception e){

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
