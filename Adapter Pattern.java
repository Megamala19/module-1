interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    void makePayment(double amount) {
        System.out.println("PayPal Payment: " + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway = new PayPalGateway();

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new PayPalAdapter();
        p.processPayment(1000);
    }
}
