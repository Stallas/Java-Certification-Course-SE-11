public class NarrowExample {
    public static void main(String[] args) {

        // we will set each variable to its maximum value in its value range
        byte b = 127;
        char c = 65535;
        short s = 32767;

        // Implicit narrowing can no longer be done because the literal does not fit the constraint.
        // C.E
//        byte b1 = 128;
//        char c1 = 65536;
//        short s1 = 32768;

        // 0.0 is double and never implicitly narrowed: compile error
//        float f2 = 0.0;
//        byte b2 = 0.0;
//        int i2 = 0.0;
//        char c2 = 0.0;
//        short s2 = 0.0;
//        long l2 = 0.0;

        int myIntVar = 1;

//        byte b2 = myIntVar;
//        char c2 = myIntVar;
//        short s2 = myIntVar;
    }
}
