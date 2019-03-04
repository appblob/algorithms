package java8;

import java.util.function.Function;

@FunctionalInterface
public interface MyComparator<T>// extends Comparable<? super T>>
{

    static <U>// extends Comparable<? super T>>
    MyComparator<U> comparing(Function<U, Comparable> f) {

        return (t1, t2) -> f.apply(t1).compareTo(f.apply(t2));
    }

    int compare(T t1, T t2);
}
