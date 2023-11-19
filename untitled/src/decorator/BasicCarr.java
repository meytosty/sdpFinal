package decorator;

public class BasicCarr implements Carr {
    @Override
    public String getDescription() {
        return "Basic Car";
    }

    @Override
    public double getCost() {
        return 100.0; // Base cost for a basic car
    }
}
