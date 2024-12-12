package String_;

/*
    Topic: Create and Manipulate Strings
    Sub-Topic:1. Recap
 */
public class StringRecap {
    public static void main(String[] args) {
        EqualLiteralReferences();
        StringConstructors();
        StringConstructorsInterned();
    }
    public static void EqualLiteralReferences() {
        /* String literals automatically interned so all "hello" literals point to same reference
        in memory, in the string pool */

        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s1 and s2 are string literals assigned to string variables :(s1==s2) = "+
                ((s1==s2) ? true : false));
    }
    public static void StringConstructors() {
         /* Now evaluates to false, strings do not point to same reference and
          are not stored in the string pool */

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("s1 and s2 are constructed string objects assigned to string variables :(s1==s2) = "+
                ((s1==s2) ? true : false));
    }
    public static void StringConstructorsInterned() {
        /*
        Add intern() method: intern checks the string pool and returns the string pool reference to s1.
         s2 also gets the string pool reference for "hello"
         */
        String s1 = new String("hello").intern();
        String s2 = new String("hello").intern();
        System.out.println("s1 and s2 are interned string objects assigned to string variables :(s1==s2) = "+
                ((s1==s2) ? true : false));
    }

}
