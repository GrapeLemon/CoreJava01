package Demo1;

import java.util.Map;

public class Person {
    public String name;
    public int age;
    public String gender;
    public Map<String,Car> cars;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", cars=" + cars +
                '}';
    }
}
