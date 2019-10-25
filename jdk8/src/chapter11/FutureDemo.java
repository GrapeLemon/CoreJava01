package chapter11;

import java.util.concurrent.*;

/**
 * @author wx-li
 * @date 2019/10/21-15:51
 **/
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return doSomeLongComputation();
            }
        });
        doSomethingElse();

        try {
            Integer result = future.get(5, TimeUnit.SECONDS);
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // ExecutionException : 计算抛出一个异常
            // InterruptedException :当前线程在等待过程中被中断
            // TimeoutException : 在Future对象完成之前超过已过期
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }

    }

    private static int doSomeLongComputation() {
        return fib(56);
    }

    private static void doSomethingElse() {
        System.out.println("i am a fool!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int f(int i) {
        return i == 1 ? 1 : i + f(i - 1);
    }

    private static int fib(int i) {
        return i == 1 || i == 2 ? 1 : fib(i - 1) + fib(i - 2);
    }
}
