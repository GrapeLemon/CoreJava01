import Cache.Person;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGuavaCache {
    @Test
    public void testUserCacheLoader(){
        // 模拟数据
        final List<Person> list = new ArrayList<Person>(5);
        list.add(new Person("1", "zhangsan"));
        list.add(new Person("2", "lisi"));
        list.add(new Person("3", "wangwu"));
        CacheBuilder<Object, Object> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100);  //设置缓存个数
    }
}
