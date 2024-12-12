/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: additional Collectors.toMap and Collectors.groupingBy
*/

import element.Pet;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExtras {
    public static void main(String[] args) {
        List<Pet> petPopulation = Stream.generate(Pet::new)
//                .distinct() has no use since multiple pet type will be produced
//                works based on Object.equals(Object) i.e. equals and hashcode
                .limit(5)
                .collect(Collectors.toList());

        petPopulation.forEach(System.out::println);

        System.out.println("--- Group by Pet using groupingBy ---");
        // Take list of Pet, collect into a Map using groupingBy
        // chain to stream of Entry and print key,values.
        petPopulation.stream()
                .collect(
                        // groupingBy with a single argument
                        Collectors.groupingBy(Pet::getType,
//  Comment below 2 lines and see the output... they are Supplier and Collector
                                TreeMap::new,// treemap used for sorting
                                Collectors.toList()))
                .entrySet()
                .stream()
                .forEach(System.out::println);

        System.out.println("--- Group by Pet using toMap ---");
        // Take list of Pet, collect into a Map using toMap
        // chain to stream of Entry and print key,values.
        petPopulation.stream()
                .distinct()// very imp results in error when groupby pettype only and without distinct
                .collect(
                        // toMap requires at least 2 arguments
                        Collectors.toMap(
//                                Pet::getType,
                                p -> p.getType() + "_" + p.getName(),
                                p -> p,//passing the entire pet type object
//  Comment below 2 lines and see the output... they are merge function used for parallel streams
                                // merge function ignored if not parallel
                                (existing, replacement) -> existing,
                                TreeMap::new))
                .entrySet()
                .stream()
                .forEach(System.out::println);

    }
}