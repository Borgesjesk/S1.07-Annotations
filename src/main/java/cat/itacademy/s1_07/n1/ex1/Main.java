package cat.itacademy.s1_07.n1.ex1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker("John", "Doe", 20.0);
        OnlineWorker onlineWorker = new OnlineWorker("Jessica", "Borges", 25.0);
        OnsiteWorker onsiteWorker = new OnsiteWorker("Emily", "Smith", 22.0);

        int hoursWorked = 160;

        System.out.println("─".repeat(40));
        System.out.println("@Override demo — polymorphic salary calculation:");
        List<Worker> workers = Arrays.asList(worker, onlineWorker, onsiteWorker);
        for (Worker w : workers) {
            System.out.println(w + " → Salary: €" + w.calculateSalary(hoursWorked));
        }
    }
}