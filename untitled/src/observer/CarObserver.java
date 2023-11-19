package observer;

public interface CarObserver {
    void update(CarSubject carSubject, String message);
}
