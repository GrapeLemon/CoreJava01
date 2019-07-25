package scheduled;

import java.util.Timer;
import java.util.TimerTask;

public class MainThreadTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "Timer thread is running...");
            }
        },500,500);
        System.out.println(Thread.currentThread() + "Main thread ends!");
    }
}
