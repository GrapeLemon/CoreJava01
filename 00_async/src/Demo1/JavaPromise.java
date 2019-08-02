package Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * 基于jdk1.8实现任务异步处理
 *
 * @author Administrator
 *
 */
public class JavaPromise {

    public static CompletableFuture<List<Person>> asynPersonTask(){
        List<Person> list = new ArrayList<>();
        // 两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<List<Person>> future = CompletableFuture.supplyAsync(new Supplier<List<Person>>() {
            @Override
            public List<Person> get() {
                System.out.println("task started!");
                //模拟耗时操作，相当于那个操作要花8秒钟 就是8秒钟之后才返回
                try {
                    Thread.sleep(2000);
                    for (int i = 0; i < 10; i++) {
                        Person p = new Person("lwx"+ i ,i,"man");
                        //方法1 这里生产这里装，当然，我们可以在令一个线程生产，然后装进去
//                        p.cars = new HashMap<String,Car>();
//                        p.cars.put(p.name,new Car("宝马",1000.00));
                        list.add(p);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return list;
            }
        }, executor);
        return future;
    }
//    public static CompletableFuture<List<Car>> asynCarTask(){
//        List<Car> list = new ArrayList<>();
//        // 两个线程的线程池
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        //jdk1.8之前的实现方式
//        CompletableFuture<List<Car>> future = CompletableFuture.supplyAsync(new Supplier<List<Car>>() {
//            @Override
//            public List<Car> get() {
//                System.out.println("task started!");
//                //模拟耗时操作，相当于那个操作要花8秒钟 就是8秒钟之后才返回
//                try {
//                    Thread.sleep(3000);
//                    for (int i = 0; i < 10; i++) {
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return list;
//            }
//        }, executor);
//        return future;
//    }

//    public static CompletableFuture<List<Person>> asynCarTask(){
//
//    }

    public static void doSomeThing() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Person>> futurePerson = asynPersonTask();
        //CompletableFuture<List<Car>> futureCar = asynCarTask();
        List<Person> people;
        try {
            people = futurePerson.get(5, TimeUnit.SECONDS);
            System.out.println(people);
        } catch (TimeoutException e) {
            System.out.println("超时了!!!!!!!");
        }


//        futurePerson.thenAccept(new Consumer<List<Person>>() {
//            @Override
//            public void accept(List<Person> list) {
//                System.out.println("造人完毕！！！！！！");
//                //实现不了把这个值拿出来 好像只能在这里处理，感觉这招的终点就是持久化数据库了
////                people  = list;
//            }
//        });
    }

    public static void main(String[] args) throws Throwable, ExecutionException {

        /**
         *      用同步的方法去思考的下面的代码话永远都想不通的，因为同步的话应该是doSomeThing()完全走完之后才到56先输出
         *
         *      但是用异步的方法去思考的话，
         */
        doSomeThing();

        System.out.println("main thread is running");

        /**
         *      这就是多线程的迷惑之处了 37行的代码明明是写在后面的，但是却先执行了
         *      也就是说实际的调用中看似顺序的步骤会发生线程的切换
         */
    }
}

