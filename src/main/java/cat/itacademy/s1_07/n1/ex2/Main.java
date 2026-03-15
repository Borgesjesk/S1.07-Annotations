package cat.itacademy.s1_07.n1.ex2;

import cat.itacademy.s1_07.n1.ex1.OnlineWorker;
import cat.itacademy.s1_07.n1.ex1.OnsiteWorker;
import cat.itacademy.s1_07.n1.ex1.Worker;

import java.util.Arrays;
import java.util.List;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        OnlineWorker onlineWorker = new OnlineWorker("Jessica", "Borges", 25.0);
        OnsiteWorker onsiteWorker = new OnsiteWorker("Emily", "Smith", 22.0);

        List<Worker> workers = Arrays.asList(onlineWorker, onsiteWorker);

        System.out.println("─".repeat(40));
        System.out.println("@Deprecated demo — calling deprecated getBonus():");
        for (Worker w : workers) {
            if (w instanceof OnlineWorker o) {
                System.out.println(o + " → Bonus: €" + o.getBonus());
            }
            if (w instanceof OnsiteWorker o) {
                System.out.println(o + " → Bonus: €" + o.getBonus());
            }
        }
    }
}