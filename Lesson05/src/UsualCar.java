import java.util.concurrent.Semaphore;

public class UsualCar extends Car {

    public UsualCar(Semaphore semaphore, String licencePlate, GasStation gasStation){
        this.semaphore = semaphore;
        this.licencePlate = licencePlate;
        this.currentGas = this.tankSize;
        this.gasStation = gasStation;
        this.consumption = 40f;
        this.tankSize = 7f;
        this.type = TypeOfCar.CAR;
    }
}
