package decorator;

public class SpoilerDecorator extends CarrDecorator {

    public SpoilerDecorator(Carr carr) {
        super(carr);
    }

    @Override
    public String getDescription() {
        return carr.getDescription() + ", with Spoiler";
    }

    @Override
    public double getCost() {
        return carr.getCost() + 50.0; // Additional cost for spoiler
    }
}