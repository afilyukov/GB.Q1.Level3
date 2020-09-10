import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class Car implements Machine, Runnable {
    protected String licencePlate;
    protected float consumption;
    protected float tankSize;
    protected float currentGas;
    protected Semaphore semaphore;
    protected GasStation gasStation;
    protected TypeOfCar type;

    public Car(){
        this.semaphore = null;
        this.licencePlate = "";
        this.currentGas = 0;
        this.gasStation = null;
    }

    @Override
    public void go() {
            System.out.printf("%s[%s] started%n", this.type, this.licencePlate);
            while (true){
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.currentGas -= consumption;
                if (currentGas < consumption) {
                    System.out.printf("%s[%s] is going to refuel%n", this.type, this.licencePlate);
                    try {
                        semaphore.acquire();
                        if (gasStation.refuel(this)) {
                            currentGas = tankSize;
                            System.out.printf("%s[%s] refueled. Going futher%n", this.type, this.licencePlate);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
     }

    @Override
    public void stop(){
        System.out.printf("%s[%s] is stopping%n", licencePlate, consumption);
    }

    @Override
    public void run() {
        go();
    }
}
