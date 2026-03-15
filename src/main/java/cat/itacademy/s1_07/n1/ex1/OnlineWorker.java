package cat.itacademy.s1_07.n1.ex1;

public class OnlineWorker extends Worker {

    private static final double INTERNET_FEE = 30.0;

    public OnlineWorker(String name, String surname, double pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public double calculateSalary(int hoursWorked) {
        return super.calculateSalary(hoursWorked) + INTERNET_FEE;
    }

    @Deprecated
    public double getBonus() {
        return INTERNET_FEE;
    }

    @Override
    public String toString() {
        return "OnlineWorker{" + super.toString() + ", internetFee=€" + INTERNET_FEE + "}";
    }
}