package decorator;

public abstract class CarrDecorator implements Carr {
    protected Carr carr;

    public CarrDecorator(Carr carr) {
        this.carr = carr;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
