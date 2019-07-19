package concurrent;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;

/**
 *  注意它在每次put() 调用时是如何休眠一秒的。这将导致Consumer在等待队列中对象的时候发生阻塞
 */
public class Producer implements Runnable{
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        try {

            while(true){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                queue.put();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
