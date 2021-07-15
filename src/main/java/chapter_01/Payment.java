package chapter_01;

public class Payment {

    public final CreditCard creditCard;
    public final Double amount;

    public Payment(CreditCard creditCard, Double amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public Payment combine(Payment payment) {
        if(creditCard.equals(payment.creditCard)) {
            return new Payment(creditCard, amount + payment.amount);
        } else {
            throw new IllegalStateException("Cards are not same");
        }
    }
}
