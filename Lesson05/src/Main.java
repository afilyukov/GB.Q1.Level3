import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore (3);
        GasStation gasStation = new GasStation(semaphore);
        new Thread(new Bus(semaphore, "001", gasStation)).start();
        new Thread(new Truck(semaphore, "002", gasStation)).start();
        new Thread(new UsualCar(semaphore, "003", gasStation)).start();
        new Thread(new Bus(semaphore, "004", gasStation)).start();
        new Thread(new Truck(semaphore, "005", gasStation)).start();
        new Thread(new Truck(semaphore, "006", gasStation)).start();
        new Thread(new UsualCar(semaphore, "007", gasStation)).start();
        new Thread(new UsualCar(semaphore, "008", gasStation)).start();
        new Thread(new UsualCar(semaphore, "009", gasStation)).start();
    }
}
