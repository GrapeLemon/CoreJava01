package Cache;

import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuavaCache {
    public void testUserCacheLoader(){
        // 模拟数据
        final List<Person> list = new ArrayList<Person>(5);
        list.add(new Person("1", "zhangsan"));
        list.add(new Person("2", "lisi"));
        list.add(new Person("3", "wangwu"));

        CacheBuilder<Object, Object> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES);
    }
}
