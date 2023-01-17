import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task12();
        task2();
        task22();
        task3();
        task33();
        task4();
        task44();
        task5();
    }
        public static void task1(){
            System.out.println("Predicate lambda");
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(5));
    }
    public static void task12(){
        System.out.println("Predicate anonim");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;}
        };
        System.out.println(predicate.test(6));
    }
    public static void task2(){
        System.out.println("Consumer lambda");
        Consumer<String> consumer = name -> System.out.println("Hello " + name);
        consumer.accept("Tod");
    }
    public static void task22(){
        System.out.println("Consumer anonim");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello " + s);
            }
        };
        consumer.accept("Maks");
    }
    public static void task3(){
        System.out.println("Function lambda");
        Function<Double, Long> function = aDouble -> aDouble.longValue();
        System.out.println(function.apply(56.4));
    }
    public static void task33(){
        System.out.println("Function anonim");
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(57.8));
    }
    public static void task4(){
        System.out.println("Suppler lambda");
        Random random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(100);
        System.out.println(supplier.get());
    }
    public static void task44(){
        System.out.println("Suppler anonim");
        Random random = new Random();
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());
    }
    public static void task5(){
        System.out.println("Task 5");
        Predicate<Integer> condition = t -> t % 2 == 0;
        Function<Integer, String> ifTrue = t -> "Nice";
        Function<Integer, String> ifFalse = t -> "Bad";
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(8));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse){

        return t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else return ifFalse.apply(t);
        };
    }




}

