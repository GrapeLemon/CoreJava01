package chapter6;

import map.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author wx-li
 * @date 2019/10/22-17:46
 **/
public class CollectorDemo {
    public static List<Person> people = Arrays.asList(
            new Person("01", "李文希1", "男",17),
            new Person("02", "李文希2", "男", 25),
            new Person("03", "李文希3", "男", 26),
            new Person("04", "李文希3", "女", 50),
            new Person("05", "李文希4", "女", 90)
    );
    public static void main(String[] args) {
        int ages = people.stream().mapToInt(Person::getAge).sum();
        System.out.println("ages = " + ages);
        System.out.println(people.stream().map(Person::getId).collect(Collectors.joining(",")));

        // 这里的逻辑就是先按性别分组,然后再按年龄段进行分组
        Map<String, Map<String, List<Person>>> map = people.stream().collect(
                    groupingBy(Person::getGender
                        ,groupingBy(person -> {
                            if (person.getAge() < 18) return "kid";
                            else if(person.getAge() < 60) return "middleAge";
                            else return "old";})));
        // 虽然是声明式调用但是多层嵌套还是挺复杂的
        System.out.println(map);
        map.forEach((gender, ageMap) ->
                ageMap.forEach((ageStr, person) -> {
                    System.out.print(gender + " -> ");
                    System.out.print(ageStr + " ");
                    System.out.println(person);
                }));
    }
}
