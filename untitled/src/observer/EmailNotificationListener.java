package observer;

public class EmailNotificationListener implements EventListener{
    private String email;
    public EmailNotificationListener(String email) {
        this.email = email;
    }
    @Override
    public void update(String eventType, CarSubject carSubject) {
        System.out.println("Email to " + this.email + ": car with " + carSubject.getCarId() + " id was " + eventType + "ed");
    }
}
