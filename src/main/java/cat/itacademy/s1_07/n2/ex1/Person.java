package cat.itacademy.s1_07.n2.ex1;

@JsonSerializable(directory = "output/json")
public class Person {

    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        if (age <= 0 || age > 110) {
            throw new IllegalArgumentException("Invalid age.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Surname cannot be blank.");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', surname='" + surname + "', age=" + age + "}";
    }
}