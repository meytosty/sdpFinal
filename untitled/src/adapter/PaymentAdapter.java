package adapter;

public class PaymentAdapter implements PaymentService {
    private ThirdPartyPaymentService thirdPartyService;

    public PaymentAdapter(ThirdPartyPaymentService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @Override
    public void makePayment(double amount) {
        // Convert our system's payment method to match the third-party service
        thirdPartyService.makePayment(amount);
    }
}
