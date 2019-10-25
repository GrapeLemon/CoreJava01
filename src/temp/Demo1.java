package temp;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wx-li
 * @date 2019/9/23-19:07
 * 演示并发问题
 **/
public class Demo1 implements Runnable{
    private int i = 0;

    public synchronized void  keepZero() {
        i++;
        i--;
        if (i != 0) {
            System.out.println("出现并发问题! i当前的值为: " + i);
        }
    }

    @Override
    public void run() {
        while (true) {
            keepZero();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService excutor = Executors.newCachedThreadPool();
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 10; i++) {
            excutor.execute(demo1);
        }
    }
}
