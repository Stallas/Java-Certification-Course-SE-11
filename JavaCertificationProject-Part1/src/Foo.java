/*
Topic:  Declare and initialize Local Variables
Sub-Topic: How to declare a variable for a primitive data type
Sub-Topic: Initializing primitive data types to literals.
* */
public class Foo {
    public static void main(String[] args) {

        // you can set all of the numeric Primitive data variables to a literal number from 0 to 127.
        byte b = 127;
        char c = 127;
        short s = 127;
        int i = 127;
        long l = 127;
        float f = 127;
        double d = 127;

        //boolean can only be set to true or false
        boolean isTrue = false;

        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("s = " + s);
        System.out.println("i = " + i);
        System.out.println("l = " + l);
        System.out.println("f = " + f);
        System.out.println("d = " + d);

        long l1 = 127l;
        long l2 = 127L;
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        float f1 = 127f;
        float f2 = 127F;
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        double d1 = 127d;
        double d2 = 127D;
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);

        float f4 = 1.27e02f;
        double d4 = 1.27e02;
        System.out.println("f4 = " + f4);
        System.out.println("d4 = " + d4);

        // we can also use binary,octal,hexadecimal forms to represent
        byte b4 = 0b1111111;  // binary 127 prefix 0b
        System.out.println("b4 = "+ b4);

        short s4 = 0177;  // octal 127 - octal prefix 0 only
        System.out.println("s4 = "+ s4);

        int i4 = 0x007F;  // hexadecimal 127 - hex prefix 0x
        System.out.println("i4 = "+ i4);

        byte b5 = 'a';
        char c5 = 'a';
        double d5 = 'a';

        System.out.println("b5 = "+ b5);
        System.out.println("c5 = "+ c5);
        System.out.println("d5 = "+ d5);

        // Unicode character slash u

        byte b6 = '\u007F';
        char c6 = '\u007F';

        System.out.println("b6 = "+ b6);
        System.out.println("c6 = "+ c6);

       // we can also use underscore in digits for readbility as long as it is not first,last. Also, commas are not valid in numeric literals.

        byte b7 = 0b0000_0001;
        char c7 = 0x0_07F;
        short s7 = 011_11;
        int i7 = 1_000_000;
        long l7 = 1_000_000L;
        float f7 = 1_000.000_000f;
        double d7 = 1.000_0000e10;

        //INVALID declarations:
//        byte b8 = 0b_0000001; // cannot have underscore directly after 0b
//        char c8 = 0x_007F;// cannot have underscore directly after 0x
//        int i8 = 10000_;// cannot have underscore at end of literal
//        long l8 = 10000_L; // cannot have underscore prior to suffix.(l/L,f/F,D/d)
//        float f8 = _1000.0000;// cannot have underscore at start of literal
//        double d8 = 1.000_e10;// underscore cannot prefix exponential in literal.

        // PDT are not Objects
//        byte b9 = null;
//        char c9 = null;
//        short s9 = null;
//        int i9 = null;
//        long l9 = null;
//        float f9 = null;
//        double d9 = null;
//
//        boolean ab = 0;
//        boolean b1 = null;

    }
}
