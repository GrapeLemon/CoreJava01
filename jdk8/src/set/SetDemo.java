package set;

import map.Person;

import java.util.*;

/**
 * @author wx-li
 * @date 2019/10/22-14:50
 **/
public class SetDemo {
    public static List<Person> people = Arrays.asList(
            new Person("01", "李文希", "女"),
            new Person("01", "李文希", "男"),
            new Person("03", "李文希3", "男"),
            new Person("04", "李文希4", "男")
    );

    public static void main(String[] args) {
        Set<Person> collect = new HashSet<>(people);
        System.out.println(collect);
        new ArrayList<>(collect);
    }
}
