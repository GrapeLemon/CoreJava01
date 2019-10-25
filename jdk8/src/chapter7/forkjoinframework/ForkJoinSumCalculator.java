package chapter7.forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author wx-li
 * @date 2019/10/23-10:38
 **/
// 继承RecursiveTask 来创建可以用于 fork/join框架的任务
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    private final long[] numbers;   // 要求和的数组
    private final int start;        // 子任务处理的数组的起始位置
    private final int end;          // 子任务处理的数组的终止位置

    // 不再将任务分解为子任务的数组大小
    public static final long THRESHOLD = 1_0000;


    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(forkJoinSum(1000_0000));
        long time = (System.nanoTime() - start) / 1_000_000;
        System.out.println("time:" + time + "ms");
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return FORK_JOIN_POOL.invoke(task);
    }


    // 公有构造器用于创建主任务
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    // 私有构造器用于以递归的方式为主任务创建子任务
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // 覆盖RecursiveTask抽象方法
    @Override
    protected Long compute() {
        // 该部分负责求和的部分的大小
        int length = end - start;
        // 如果小于或等于阈值,顺序计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        // 创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        // 使用另一个 ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();    // 所以这个fork相当于是执行任务的意思啊
        // 创建一个任务来为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        // 同步执行第二个子任务,有可能允许进一步递归划分
        Long rightResult = rightTask.compute(); //可以看到这里是递归调用了 运行了分治法的思想 分到阈值点就不再分了 开始计算
        // 读取第一个子任务的结果 如果尚未完成就等待
        Long leftResult = leftTask.join();
        //该任务的结果是两个子任务结果的组合
        return leftResult + rightResult;
    }

    // 在子任务不再可分时计算结果的简单算法
    private long computeSequentially() {
        long sum = 0;
        // 注意观察这里 由于迭代只计算start坐标的值而不会计算end坐标的值,
        // 所以假设数组中共有10个元素,两段式的坐标为 [0,5),[5,10),
        // 将对坐标为0,1,2,3,4 | 5,6,7,8,9 进行求和,没多也没少,刚刚好
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
