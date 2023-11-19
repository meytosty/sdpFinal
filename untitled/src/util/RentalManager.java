package util;
import factory.Car;
import factory.Sedan;
import observer.CarStatusObserver;
import observer.CarSubject;

import java.util.HashMap;
import java.util.Map;

public class RentalManager {
    private static RentalManager instance;
    private Map<CarSubject, Double> rentedCars; // Store car ID and associated rental price

    public CarStatusObserver events;

    private RentalManager() {
        rentedCars = new HashMap<>();
        events = new CarStatusObserver("rent");
    }

    public static RentalManager getInstance() {
        if (instance == null) {
            instance = new RentalManager();
        }
        return instance;
    }

    public void rentCar(CarSubject carSubject, double price) {
        rentedCars.put(carSubject, price);
        events.notify("rent", carSubject);
        System.out.println("Car ID: " + carSubject.getCarId() + " rented for $" + price);
    }

    public void returnCar(String carId) {
        if (rentedCars.containsKey(carId)) {
            double price = rentedCars.remove(carId);
            System.out.println("Car ID: " + carId + " returned. Payment of $" + price + " completed.");
        } else {
            System.out.println("Car ID: " + carId + " not found in the rented cars list.");
        }
    }

    public void displayRentedCars() {
        if (rentedCars.isEmpty()) {
            System.out.println("No cars are currently rented.");
        } else {
            System.out.println("List of Rented Cars:");
            for (Map.Entry<CarSubject, Double> entry : rentedCars.entrySet()) {
                System.out.println("Car ID: " + entry.getKey() + ", Rental Price: $" + entry.getValue());
            }
        }
    }

    // Other rental management methods...
}

