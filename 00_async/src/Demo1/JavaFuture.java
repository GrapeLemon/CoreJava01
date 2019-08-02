package Demo1;

import java.util.concurrent.*;

/**
 * jdk1.8之前的Future
 *
 * @author Administrator
 *
 */
public class JavaFuture {
    public static void main(String[] args) throws Throwable, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // Future代表了线程执行完以后的结果，可以通过future获得执行的结果
        // 但是jdk1.8之前的Future有点鸡肋，并不能实现真正的异步，需要阻塞的获取结果，或者不断的轮询
        // 通常我们希望当线程执行完一些耗时的任务后，能够自动的通知我们结果，很遗憾这在原生jdk1.8之前
        // 是不支持的，但是我们可以通过第三方的库实现真正的异步回调
        Future<String> f = executor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("task started!");
                Thread.sleep(1000*60);  //现在是阻塞一分钟，但是如果阻塞10分钟？100分钟呢？这种浪费资源的方式是相当不可取的！
                System.out.println("task finished!");
                return "hello";
            }
        });

        //此处阻塞main线程
        System.out.println(f.get());
        System.out.println("main thread is blocked");       //30行没有执行完的话，31行也不会执行，这就是阻塞!是一种相当浪费CPU资源的行为
    }
}
