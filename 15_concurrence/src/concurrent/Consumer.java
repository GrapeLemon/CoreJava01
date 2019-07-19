package concurrent;

import java.util.concurrent.BlockingQueue;

/**
 *  以下是Consumer类。它只是把对象从队列中抽取出来，然后将它们打印出来
 */

public class Consumer implements Runnable{
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
