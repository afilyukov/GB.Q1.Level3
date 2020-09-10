
import java.util.concurrent.Semaphore;


public class GasStation  {

    private final Semaphore semaphore;

    public GasStation(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public boolean refuel(Car car) {
          try {
              System.out.println("GASSTATION: " + car.type + " [" + car.licencePlate + "] refueling");
              Thread.sleep(5000);
              semaphore.release();
              System.out.println("GASSTATION: " + car.type + " " + car.licencePlate + " refueled");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          return true;
    }
}
