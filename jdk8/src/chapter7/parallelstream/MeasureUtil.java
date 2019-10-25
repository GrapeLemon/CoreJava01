package chapter7.parallelstream;

import chapter7.forkjoinframework.ForkJoinSumCalculator;

import java.util.function.Function;

/**
 * @author wx-li
 * @date 2019/10/23-9:43
 **/
public class MeasureUtil {
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("sum = " + sum);
        return fastest;
    }

    public static void main(String[] args) {
        // 以下输出由快到慢 请解释产生以下结果的原因
        System.out.println("Sequential sum done in:" +
                measureSumPerf(SumUtil::sequentialSum, 10_000_000) + " msecs");
        System.out.println("Parallel sum done in:" +
                measureSumPerf(SumUtil::parallelSum, 10_000_000) + " msecs");
        System.out.println("Iterative sum done in:" +
                measureSumPerf(SumUtil::iterativeSum, 10_000_000) + " msecs");
        System.out.println("Sequential ranged sum done in:" +
                measureSumPerf(SumUtil::rangedSum, 10_000_000) + " msecs");
        System.out.println("parallel ranged sum done in:" +
                measureSumPerf(SumUtil::parallelRangedSum, 10_000_000) + " msecs");
        System.out.println("SideEffect sum done in: " +
                measureSumPerf(SumUtil::sideEffectSum, 10_000_000L) +" msecs");
        // 不仅结果不对速度也不快....
        System.out.println("SideEffect parallel sum done in: " +
                measureSumPerf(SumUtil::sideEffectParallelSum, 10_000_000L) +" msecs");
        System.out.println("ForkJoin sum done in: " + measureSumPerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs" );

    }
}
