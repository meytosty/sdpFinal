package observer;

import java.util.ArrayList;
import java.util.List;

public class CarSubject {
    private List<CarObserver> observers;
    private String carId;
    private String carStatus;

    public CarSubject(String carId) {
        this.carId = carId;
        this.observers = new ArrayList<>();
        this.carStatus = "Available"; // Initial status
    }

    public void attach(CarObserver observer) {
        observers.add(observer);
    }

    public void detach(CarObserver observer) {
        observers.remove(observer);
    }


    public void notifyObservers(String message) {
        for (CarObserver observer : observers) {
            observer.update(this, message);
        }
    }

    public void updateCarStatus(String newStatus) {
        this.carStatus = newStatus;
        notifyObservers("Status updated: " + newStatus);
    }
    public String getCarId() {
        return this.carId;
    }
    public String getStatus() {
        return this.carStatus;
    }

    // Other methods for updating car information or triggering specific notifications...
}

