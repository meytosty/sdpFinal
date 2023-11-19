package factory;

import observer.CarObserver;

public class Coupe implements Car {
    @Override
    public String getDescription() {
        return "Coupe Car";
    }
}