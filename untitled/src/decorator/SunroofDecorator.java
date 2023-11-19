package decorator;

public class SunroofDecorator extends CarrDecorator {

    public SunroofDecorator(Carr carr) {
        super(carr);
    }

    @Override
    public String getDescription() {
        return carr.getDescription() + ", with Sunroof";
    }

    @Override
    public double getCost() {
        return carr.getCost() + 80.0; // Additional cost for sunroof
    }
}
