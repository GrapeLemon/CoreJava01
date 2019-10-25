package chapter7.parallelstream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author wx-li
 * @date 2019/10/22-9:44
 **/
public class SumUtil {

    // 使用流求1到n的和
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }
    // 使用迭代来求1到n的和
    public static long iterativeSum(long n) {
        long result = 0L;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }
    // 使用并行流求1到n的和
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
    // 使用更有针对性的 LongStream,避免无谓的装箱拆箱操作从而影响性能
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L,Long::sum);
    }

    // 使用并行流进一步提高性能
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    // 结果正确,但是这段代码依然是有副作用的代码,现在结果正确仅仅是因为是顺序执行,
    // 一旦使用了多线程去执行这段代码结果就会出错
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .forEach(accumulator::add);
        return accumulator.total;
    }

    //不正确计算结果:在使用了多线程的情况下非互斥的改变了共享变量导致了结果不正确
    // 而且速度也不快 原因应该是访问共享变量导致的
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }

}
