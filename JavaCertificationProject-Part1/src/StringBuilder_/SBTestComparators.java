package StringBuilder_;
/*
    Topic: Manipulate Data With StringBuilder
    Sub-Topic:4. Comparing Comparators
    ==,.equals,compareTo, == and .equals using strings and interns
 */
public class SBTestComparators {
    public static void main(String[] args) {
        // set up some test data

        StringBuilder sb1 = new StringBuilder("This is a test");
        StringBuilder sb2 = new StringBuilder("This is a test");
       // StringBuilder sb2 = sb1;

        // == comparator (compares references)
        System.out.println("sb1 == sb2" + (sb1 == sb2));

        // .equals operator from java.lang.Object
        System.out.println("sb1.equals(sb2)" + (sb1.equals(sb2)));

        //.compareTo method defined on StringBuilder Object
        System.out.println("sb1.compareTo(sb2)" + (sb1.compareTo(sb2)));

        //.equals used to compare String values of StringBuilder Objects
        System.out.println("sb1.toString().equals(sb2.toString())))" + (sb1.toString().equals(sb2.toString())));

        // == used to compare String Values of StringBuilder Objects
        System.out.println("sb1.toString() == sb2.toString())" + (sb1.toString() == sb2.toString()));
        System.out.println("sb1.toString() == sb2.toString().intern())" + (sb1.toString() == sb2.toString().intern()));
        System.out.println("sb1.toString().intern() == sb2.toString().intern())" + (sb1.toString().intern() == sb2.toString().intern()));

    }
}
