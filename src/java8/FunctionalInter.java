package java8;

import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInter {
    public static void main(String[] args) {
        Comparator<String> c = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        Runnable r = () -> {
            for(int i = 0; i < 10; i++) {
                    System.out.println("Running on thread : " + Thread.currentThread().getName());
            }
        };

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(r);

        /// Method reference
        BinaryOperator<Integer> Sum1 = (n1,n2) -> n1 + n2;
        BinaryOperator<Integer> Sum2 = (n1,n2)->Integer.sum(n1, n2);
        BinaryOperator<Integer> Sum3 = Integer::sum;

        System.out.println(Sum3.apply(10, 50));

        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello");


        MyComparator<Person> compareAge = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        MyComparator<Person> compareName = (p1, p2) -> p1.getfName().compareTo(p2.getfName());


        // Function that takes a person and returns age
        Function<Person, Integer> fAge = Person::getAge;
        Function<Person, String> ffName = Person::getfName;

        MyComparator<Person> compareAge1 = MyComparator.comparing(Person::getAge);
        MyComparator<Person> compareName2 = MyComparator.comparing(Person::getfName);


    }
}
