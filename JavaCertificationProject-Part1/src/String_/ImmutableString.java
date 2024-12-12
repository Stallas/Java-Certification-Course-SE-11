package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic:2. Immutable Strings
 */

public class ImmutableString {
    public static void main(String[] args) {

        // "Hello" exists on the string pool, s1 gets a reference to it.
        String s1 = "Hello";

        /*
        The following code does not change the value of "Hello World" and passes the reference to
        this new string to s1;
        "Hello World" not adding to string pool unless intern() called.
         */

        s1 = s1 + " World";
        System.out.println(s1);

        /*
        Let's reset s1 and show another example using String's concat
         */

        s1 = "Hello";
        s1.concat(" World");
        System.out.println(s1);
    }
}
