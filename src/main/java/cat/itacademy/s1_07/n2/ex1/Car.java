package cat.itacademy.s1_07.n2.ex1;

@JsonSerializable(directory = "output/json")
public class Car {

    private final String model;
    private final String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() { return model; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Car{model='" + model + "', color='" + color + "'}";
    }
}