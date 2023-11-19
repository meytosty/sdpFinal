package observer;

import java.util.*;

public class CarStatusObserver implements CarObserver {
    private String observerId;
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public CarStatusObserver(String ...operations) {
        for (String operation: operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }
    public void notify(String eventType, CarSubject carSubject) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.update(eventType, carSubject);
        }
    }

    @Override
    public void update(CarSubject carSubject, String message) {
        System.out.println("Observer " + observerId + ": Car ID " + carSubject.getCarId() + " - " + message);
    }
}
