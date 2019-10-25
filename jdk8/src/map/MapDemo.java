package map;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author wx-li
 * @date 2019/10/22-14:32
 **/
public class MapDemo {
    public static List<Person> people = Arrays.asList(
            new Person("01", "李文希", "男"),
            new Person("02", "李文希", "男"),
            new Person("03", "李文希3", "男"),
            new Person("04", "李文希4", "男")
            );

    public static void main(String[] args) {
            // 这样的话就可以很方便的得到 部门id : 部门名称的Map了,轻松解决任务
            // 这样搞可以比较把一个元素的某些属性转换为映射表
            // 这样搞就真的复杂了一点,不过还好,可以做到映射新的类型的对象
            Map<String, SimplePerson> map1 = people
                    .stream()
                    .collect(toMap(Person::getId,
                            person -> new SimplePerson(person.getName(),person.getGender())));
            System.out.println(map1);

            Map<String, String> map2 = people
                    .stream()
                    .collect(toMap(person -> person.getName(), Person::getId, (key1,key2) -> key2));
        System.out.println(map2);

        // 这种的使用场合一般是有几种类型,然后你想把流里面元素按类型进行分组
        Map<String, List<Person>> map3 = people.stream().collect(groupingBy(Person::getName));
        Map<String, List<String>> map4 = new HashMap<>();
        map3.forEach((k,v) -> map4.put(k, v.stream().map(Person::getId).collect(toList())));
        System.out.println(map4);

        // 感觉会不会太复杂了?能不能再优化一下? 好像不行了感觉.. 不给那样写主要是
        // 这样写是可行的,但不能像达到map4的效果,要做分组还是用上面的写法吧
        Map<String, List<String>> map5 = people.stream().collect(toMap(Person::getId,
                v -> people.stream().map(Person::getId).collect(toList())));
        System.out.println("map5 = " + map5);
    }
}
