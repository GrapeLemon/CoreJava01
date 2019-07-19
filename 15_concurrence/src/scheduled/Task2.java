package scheduled;

import java.util.Timer;
import java.util.TimerTask;

/** 
  *  
  * 于第一种方式相比，优势 1>当启动和去取消任务时可以控制 2>第一次执行任务时可以指定你想要的delay时间 
  *  
  * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。 
  * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。 下面是代码： 
  *  
  */
public class Task2 {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //do something
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 5 * 1000;
        long intevalPeroid = 1 * 1000;
        /*
            设置延迟多久启动和间隔多久执行1次，要反复执行直到线程终止
            注意，这个已经是周期性任务，就不用像Task1那样写 while(true)这种别扭的代码了
            周期性任务的本质就是: 在线程没有死亡的情况下，会反复按设置执行任务！
            一开始有个惯性思维，觉得这个方法好像给人感觉不会启动线程去执行，导致一直 理解不了 -> 记忆不了
         */
        //timer.scheduleAtFixedRate(task,delay,intevalPeroid);

        /*
            设置延迟多久启动，因为没有间隔时间，所以只会执行一次
            执行完以后线程也不会终止，这就有点麻烦了，看来一定要用线程池进行管理
         */
        timer.schedule(task,delay);
    }
}
