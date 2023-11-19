package strategy;

public class DailyPricingStrategy implements PricingStrategy {
    private static final double DAILY_RATE = 50.0;

    @Override
    public double calculatePrice(int duration) {
        return DAILY_RATE * duration;
    }
}