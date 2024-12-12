/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 12:  Parallel Stream
Topic:  Develop the code that uses parallel stream
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamCreation {
    public static void main(String[] args) {
        // Create a list of integers, multiples of 1 to 20
        List<Integer> integerList = Stream.iterate(
                1, (t) -> t <= 20, (t) -> t + 1)
                .collect(Collectors.toList());

        System.out.println("-----  Serial stream results -----");
        // Create stream from integerList 
        for (int i = 0; i < 5; i++) {
            integerList.stream()
                    .forEach((s) -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("----- Apply parallel operator to stream -----");
        // Turn a stream to a parallel stream by using parallel intermediate
        // operation on the stream.
        for (int i = 0; i < 5; i++) {
            integerList.stream()
                    .parallel()
                    .forEach((s) -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("----- Getting a parallel stream from List -----");
        // Create parallel stream from integerList using parallelStream() method
        // forEachOrdered --> it produces output in order
        for (int i = 0; i < 5; i++) {
            integerList.parallelStream()
                    .forEachOrdered((s) -> System.out.print(s + " "));
            System.out.println();

        }

        // Attempting to change the underlying operation.Results in java.util.ConcurrentModificationException
        /*
        for (int i = 0; i < 5; i++) {
            integerList.parallelStream()
                    .map((s) -> {
                        integerList.add(s);
                        return s;
                    })
                    .forEachOrdered((s) -> System.out.print(s + " "));
            System.out.println();

        }*/
        System.out.println("----- Using stateful lambda expression -----");
        //  Create parallel stream from integerList using parallelStream() method
        /*
        List<Integer> unSynchList = new ArrayList<>();
        Using an unsynchronised list results in memory consistency error....
        i.e. not even 20 elements were produced and all in not order.
        Hence, use synchList for consistent in place of unSynchList
         */
         /*
         List<Integer> synchList = Collections.synchronizedList(integerList.subList(0,10));
         Results in ConcurrentModificationException.
         */
        List<Integer> unSynchList = new ArrayList<>();
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
//        List<Integer> synchList = Collections.synchronizedList(integerList.subList(0,10));
        for (int i = 0; i < 5; i++) {
            synchList.clear();
            integerList
                    .parallelStream()
                    // stateful lambda expression
                    .forEach((s) -> {
                        synchList.add(0, s);
                    });
            System.out.println(synchList);

        }


    }
}