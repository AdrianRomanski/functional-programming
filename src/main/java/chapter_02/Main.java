package chapter_02;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Integer> triple = arg -> arg * 3;
        Function<Integer, Integer> square = arg -> arg * arg;

        System.out.println(square.apply(triple.apply(2)));
        final var compose = compose(square, triple);
        final var composed = compose.apply(2);

        System.out.println(composed);

        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;

        final var apply = add.apply(2).apply(2);

        System.out.println(apply);

        BinaryOperator addBinary = x -> y -> x + y;
        BinaryOperator mult = x -> y -> x * y;

        System.out.println(addBinary.apply(1).apply(2));

        Function<Function<Integer, Integer>,
                    Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> composeFunctions =  x -> y -> z -> x.apply(y.apply(z));

        composeFunctions.apply(triple).apply(square);

        final var apply1 = Functions.<Integer, Integer, Integer>higherCompose().apply(triple).apply(square);

        apply1.apply(4);


        // higher compose testing

        Function<Double, Integer> f = a -> (int) (a * 3);
        Function<Long, Double> g = a -> a + 2.0;

        Functions.<Long, Double, Integer>higherCompose().apply(f).apply(g).apply(14L);

        //annonymous functions

        final var cos = Functions.<Double, Double, Double>higherCompose()
                .apply(z -> Math.PI / 2 - z).apply(Math::sin).apply(2.0);

    }

    public static Function<Integer, Integer> compose(final Function<Integer, Integer> f1,
                                                     final Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }





}
