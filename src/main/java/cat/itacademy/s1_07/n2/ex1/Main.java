package cat.itacademy.s1_07.n2.ex1;

public class Main {

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();

        System.out.println("─".repeat(40));
        System.out.println("Serializing annotated classes:");
        serializer.serialize(new Person("Jessica", "Borges", 30));
        serializer.serialize(new Car("Ferrari", "Red"));

        System.out.println("─".repeat(40));
        System.out.println("Serializing non-annotated class:");
        serializer.serialize(new Pet("Cat", "Luna"));
    }
}