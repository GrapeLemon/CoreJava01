package Demo1;

public class Car {
    public String brand;
    public Double cost;

    public Car(String brand, Double cost) {
        this.brand = brand;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }
}
