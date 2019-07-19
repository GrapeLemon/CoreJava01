package scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 
  * ScheduledExecutorService是从Java SE5的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式。  
  * 相比于上两个方法，它有以下好处： 
  * 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的  
  * 2>可以很灵活的去设定第一次执行任务delay时间 
  * 3>提供了良好的约定，以便设定执行的时间间隔 
  *  
  * 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，通过代码里参数的控制，首次执行加了delay时间。 
  *  
  */
public class Task3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //task,you can do something by this Thread
                System.out.println("Hello!!");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        //有AtFixedRate作为后缀的话就是周期性任务
//        service.scheduleAtFixedRate(runnable,10,1, TimeUnit.SECONDS);

        //只有schdule的话就是一次性任务，但是线程并不会终止,估计是使用了线程池的原因
        service.schedule(runnable,5, TimeUnit.SECONDS);

    }
}
