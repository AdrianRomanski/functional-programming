package chapter_01;

import java.util.Collections;
import java.util.List;

public class DonutShop {

    public static Tuple<Donut, Payment> buyDonut(CreditCard creditCard) {
        Donut donut = new Donut(2.17);
        Payment payment = new Payment(creditCard, donut.getPrice());
        return new Tuple<>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity, final Double price,  final CreditCard creditCard) {
        return new Tuple<>(Collections.nCopies(quantity, new Donut(price)),
                new Payment(creditCard, price * quantity));
    }

    // Not yet implemented
//    public static List<Payment> groupByCard(List<Payment> payments) {
//        return payments
//                .groupBy(x -> x.creditCard)
//                .values()
//                .map(x -> x.reduce(c1 -> c2 -> c1.combine(c2)));
//    }




}
