import java.util.concurrent.Semaphore;

public class Truck extends Car {

    public Truck (Semaphore semaphore, String licencePlate, GasStation gasStation){
        this.semaphore = semaphore;
        this.licencePlate = licencePlate;
        this.currentGas = this.tankSize;
        this.gasStation = gasStation;
        this.consumption = 15f;
        this.tankSize = 60f;
        this.type = TypeOfCar.TRUCK;
    }
}
