/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Collect and Reduce
*/
/*
Serial streams, parallel streams, reduce 3 overloaded methods, collect 2 overloaded methods
Using StringBuilder
 */
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParallelExtras {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>(Set.of("b", "c", "d"));
        // test with parallelStream() ,if source is ordered, then result is ordered.
        // Using reduce with String
        String firstResultString = set
                .stream()
                .reduce(String::concat)
//                .reduce("", String::concat)// all three methods returns the same output
//                .reduce("", String::concat, String::concat)
                // reduce returns Optional, need to use get() to get value
                .get();

        System.out.println("firstResultString = " + firstResultString);

        // Using collect with String
        String secondResultString = set
                .stream()
                // collect requires Collector argument
                .collect(Collectors.joining());
//         .collect("", String::concat, String::concat);// results in compiler error as first parameter
//          needs to be a Supplier object.
//        .collect(String::new, String::concat, String::concat);// empty string as it modifies original string to new

        System.out.println("secondResultString = " + secondResultString);


        /*
        StringBuilder::append method reference cannot be used because that method only accepts a
        single parameter, and for all the arguments, a BiFunction, or BinaryOperator or BiConsumer
        is required, so we use a lambda expression in all instances.
        Note also the first parameter of the reduce and collect methods are different in the same manner
        as previously. The reduce method requires an identity or an Object instance, and the collect
        method requires a Supplier, a method that returns an Object instance.
        test using both stream() and parallelStream()
         */
        // Using reduce with StringBuilder
        StringBuilder firstResultSB = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder(),
                        (a, b) -> b.append(a),
//                        (a, b) -> a.append(b),
                        (a, b) -> a.append(b));

        System.out.println("firstResultSB = " + firstResultSB);

        // Using collect with StringBuilder
        StringBuilder secondResultSB = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(StringBuilder::new,
//                        (a, b) -> a.append(b),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("secondResultSB = " + secondResultSB);

        // Using reduce with StringBuilder
        StringBuilder firstResult = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // Requires Identity(StringBuilder), BiFunction, BinaryOperator
                .reduce(new StringBuilder("a"),
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));

        System.out.println("firstResult = " + firstResult);

        // Using collect with StringBuilder
        StringBuilder secondResult = set
                .parallelStream()
                .map(s -> new StringBuilder(s))
                // collect requires Supplier, BiConsumer, BiConsumer
                .collect(() -> { return new StringBuilder("a"); },
                        (a, b) -> b.append(a),
                        (a, b) -> a.append(b));
        System.out.println("secondResult = " + secondResult);
    }
}