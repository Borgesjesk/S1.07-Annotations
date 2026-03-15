package cat.itacademy.s1_07.n1.ex1;

public class Worker {

    private final String name;
    private final String surname;
    private final double pricePerHour;

    public Worker(String name, String surname, double pricePerHour) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Surname cannot be null or blank.");
        }
        if (pricePerHour <= 0) {
            throw new IllegalArgumentException("Price per hour must be greater than 0.");
        }
        this.name = name;
        this.surname = surname;
        this.pricePerHour = pricePerHour;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public double getPricePerHour() { return pricePerHour; }

    public double calculateSalary(int hoursWorked) {
        if (hoursWorked <= 0) {
            throw new IllegalArgumentException("Hours worked must be greater than 0.");
        }
        return hoursWorked * pricePerHour;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (€" + pricePerHour + "/h)";
    }
}