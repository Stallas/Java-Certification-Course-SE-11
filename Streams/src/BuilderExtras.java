/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream.Builder
*/

import java.util.stream.Stream;

public class BuilderExtras {
    public static void main(String[] args) {

        // Builder is mutable object, so like a StringBuilder,
        // you do not need to self reference, but you can...
        Stream.Builder<String> builder = Stream.builder();
        builder = builder.add("a");  // ok but not necessary
        builder.add("b");  // this works
        builder.add("c");
//        builder.add(10); // Compiler time error

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
//        builder.add("d");//you cant invoke after build method illegalStateException

        // Using a raw Builder with chained methods -- no compiler error works fine
//        Stream.builder().add("a").add(10).build().forEach(
//                System.out::println);

//        Stream.<String>builder().add("a").add(10).build().forEach(
//                System.out::println);//compiler error

        // Typing builder() method returns correctly typed Stream
        Stream.<String>builder().add("a").add("b").build().forEach(
                System.out::println);

        // Using a rawBuilder
        Stream.Builder builder3 = Stream.<String>builder();
        builder3.add("a");
        builder3.add(new Object());
        Stream<String> s3 = builder3.build();
        s3.forEach(System.out::println); // on runtime classcastexception
    }
}