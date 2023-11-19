package factory;

public class CarFactory {
    public Car createCar(String type) {
        if (type.equalsIgnoreCase("sedan")) {
            return new Sedan();
        } else if (type.equalsIgnoreCase("coupe")) {
            return new Coupe();
        }
        // Handle unknown types or return a default
        return new Sedan(); // Default type as Sedan
    }
}