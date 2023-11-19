package strategy;

public class WeeklyPricingStrategy implements PricingStrategy {
    private static final double WEEKLY_RATE = 300.0;

    @Override
    public double calculatePrice(int duration) {
        return WEEKLY_RATE * (duration / 7); // Assuming duration is in days
    }
}
