package chapter7.parallelstream;

/**
 * @author wx-li
 * @date 2019/10/23-10:14
 **/
public class Accumulator {
    public long total = 0;

    // 上了锁之后结果是对了 但是效率非常低.. 要400多ms,相比了最快的3ms,满了差不多150倍....
    public synchronized void add(long value) {
        total += value;
    }
}
