package cat.itacademy.s1_07.n2.ex1;

public class Pet {

    private final String animal;
    private final String name;

    public Pet(String animal, String name) {
        this.animal = animal;
        this.name = name;
    }

    public String getAnimal() { return animal; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Pet{animal='" + animal + "', name='" + name + "'}";
    }
}