package chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toList;

/**
 * @author wx-li
 * @date 2019/10/21-17:49
 **/
public class TestFindPrices {
    // 调整线程池大小 线程的数量 = 处理器的核的数目 * 期望的CPU利用率 * (1 + 等待时间与计算时间的比例)
    // 书上有介绍公式的内容 这里作者建议将线程池的大小设置为跟商店的数量一致.但是同时也要设置一个上线,避免
    // 由于商店的数目过多导致服务器超负荷而崩溃
    static final int ProcessorNum = Runtime.getRuntime().availableProcessors();

    static final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("hey there"));

    static final Executor excutor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            });


    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findPricesAsync("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    public static List<String> findPricesParallelStream(String product) {
        System.out.println("使用并行流!");
        // 使用并行流可以将性能提高到4倍
        return shops.parallelStream().map(shop ->
                String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPricesAsync(String product) {
        System.out.println("使用future进行异步!");
        List<CompletableFuture<String>> priceFuture = shops.stream().
                map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(), shop.getPrice(product)), excutor))
                .collect(toList());
        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }
}
