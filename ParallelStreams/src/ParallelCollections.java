/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Reductions using stream.collect
*/

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Persons will be used to test collect() method with toMap and groupingBy
class Person {
    private static int id_counter;
    private static String[] names = {"Anne", "Bob", "Carol", "David",
            "Evan", "Fred", "George", "Harold", "Ida", "Jack", "Kevin"};

    private String name;
    private int id;
    private int age;

    // Constructor
    Person() {
        Random random = new Random();
        this.name = names[new Random().nextInt(11)];
        this.id = ++id_counter;
        this.age = random.nextInt(99);
    }

    // Getters, will be used in mappings
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}

// Class that tests concurrent reductions
public class ParallelCollections {
    public static void main(String[] args) {

        // Create a Collector using Collectors.toMap
        Collector c1 = Collectors.toMap(String::length, s -> s);
        System.out.println("Characteristics of Collectors.toMap() are "
                + c1.characteristics());

        // Create a Collector using Collectors.toConcurrentMap
        Collector c2 = Collectors.toConcurrentMap(String::length, s -> s);
        System.out.println("Characteristics of Collectors." +
                "toConcurrentMap() are " + c2.characteristics());

        // Create a Collector using Collectors.groupingBy
        Collector c3 = Collectors.groupingBy(Person::getAge);
        System.out.println("Characteristics of Collectors." +
                "groupingBy(Person::getAge) are " + c3.characteristics());

        // Create a Collector using Collectors.groupingByConcurrent
        Collector c4 = Collectors.groupingByConcurrent(
                String::toString, Collectors.toList());
        System.out.println("Characteristics of Collectors." +
                "groupingByConcurrent() are " + c4.characteristics());

        // Create a List of randomly generated Persons.
        Set<Person> personList = Stream.generate(Person::new)
                .limit(2_000_000)//200
                .collect(Collectors.toSet());

       testToMap(personList);// when limit is increasing then concurrentmap performs better.

        testGroupingBy(personList);

    }

    // Method tests toMap and toConcurrentMap and prints out time
    // elapsed
    static void testToMap(Set<Person> personList) {
        long start = System.currentTimeMillis();

        // Serial Stream, uses toMap to collect data into a map
        Map<Integer, Person> personMap =
                personList
                        .stream()
                        .collect(Collectors.toMap(
                                Person::getId, p -> p));

        System.out.println("serial: toMap: " +
                (System.currentTimeMillis() - start) + " ms");

        //-----------------------------------------------------
        start = System.currentTimeMillis();
        // Parallel Stream uses toMap to collect data into a map
        Map<Integer, Person> personMap1 =
                personList
                        .parallelStream()
                        .collect(Collectors.toMap(
                                Person::getId, p -> p));

        System.out.println("parallel: toMap: " +
                (System.currentTimeMillis() - start) + " ms");

        //-----------------------------------------------------
        start = System.currentTimeMillis();
        // Parallel Stream uses toConcurrentMap to collect data into map
        Map<Integer, Person> personMap2 =
                personList
                        .parallelStream()
                        .collect(Collectors.toConcurrentMap(
                                Person::getId, p -> p));

        System.out.println("parallel: toConcurrentMap: " +
                (System.currentTimeMillis() - start) + " ms");

    }

    // Method tests groupingBy and groupingByConcurrent and e
    // prints out time elapsed
    static void testGroupingBy(Set<Person> personList) {
        long start = System.currentTimeMillis();

        // Serial Stream, uses groupingBy to collect data into a map
        Map<Integer, List<Person>> m =
                personList
                        .stream()
                        .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("stream: groupingBy: " +
                (System.currentTimeMillis() - start) + " ms");
        //-----------------------------------------------------
        start = System.currentTimeMillis();
        // Parallel Stream, uses groupingBy to collect data into a map
        Map<Integer, List<Person>> m1 =
                personList
                        .parallelStream()
                        .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("parallel: groupingBy: " +
                (System.currentTimeMillis() - start) + " ms");
        //-----------------------------------------------------
        start = System.currentTimeMillis();
        // Parallel Stream, uses groupingByConcurrent to collect data
        // into a map
        Map<Integer, List<Person>> m2 =
                personList.parallelStream()
                        .collect(Collectors.
                                groupingByConcurrent(Person::getAge));

        System.out.println("parallel: groupingByConcurrent: " +
                (System.currentTimeMillis() - start) + " ms");

    }
}