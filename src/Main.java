import java.util.Objects;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.x(5));

        System.out.println("_____________________________________");

        Consumer<String> consumer = name -> System.out.println("Hello " + name);
        consumer.accept("Tod");

        System.out.println("_____________________________________");

        Function<Double, Long> function = aDouble -> aDouble.longValue();
        System.out.println(function.apply(56.4));

        System.out.println("_____________________________________");
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(100);
        System.out.println(supplier.get());

    }

    public static void main2(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean x(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println(predicate.x(6));

        System.out.println("_____________________________________");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello " + s);
            }
        };
        consumer.accept("Maks");

        System.out.println("_____________________________________");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(57.8));

        System.out.println("_____________________________________");

        Random random = new Random();
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return null;
    }

    public static void main3(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength);
    }
}

