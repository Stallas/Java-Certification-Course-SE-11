/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  Using assertions
*/
package assertion;

import assertion.invariant.InvariantExamples;

public class AssertionExample {
// Here static block terminates the entire program if assertions are enabled.... disable by removing -ea.
    static {
        boolean startupAllowed = false;

        // startupAllowed will be true ONLY if assertions are enabled
        // otherwise statement is simply ignored.
        assert startupAllowed = true;

        // The following statement prevents the class from loading...
        if (!startupAllowed)
            throw new RuntimeException("Assertions must be enabled!!!");
    }

    // enum maintains detailed messages Assertion Errors.
    enum assertFlags {
        BYTE_OUT_OF_RANGE("Value is out of range for a byte");

        private String message;

        assertFlags(String message) {
            this.message = message;
        }
    }

    // Method to be used by assert statement to populate detailed message
    public static String getAssertMessage(assertFlags aflag) {
        return "Method returns " + aflag.message;
    }

    public static void printAssertMessage(assertFlags aflag) {
        System.out.println("Method returns " + aflag.message);
    }

    public static void main(String[] args) {
/*  When assertions are enabled, then assertion error thrown from InvariantExample class.
If you want to ignore assertion errors in this class then add the following commands in VM options:
-ea  -da:assertion.invariant.InvariantExamples
i.e. InvariantExamples class runs with assertions disabled. Rest all output is printed out.
-ea assertion... --> This enables all classes in assertions package to have assertions enabled.
-ea assertion...  -da:assertion.invariant.InvariantExamples --> Specifically disables one class.
 */
        InvariantExamples.main(args);

        byte s2;

        // Value below exceeds Byte Max Value
        short maxValue = Byte.MAX_VALUE + 1;

        //  assert that value is within the proper range for byte
        assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE :
//                "Value out of range for a byte"
//                getAssertMessage(assertFlags.BYTE_OUT_OF_RANGE)
//                printAssertMessage(assertFlags.BYTE_OUT_OF_RANGE); compiler error as void type not allowed
                assertFlags.BYTE_OUT_OF_RANGE;

        // Casting short to a byte could lead to undetected overflow..
        s2 = (byte) maxValue;

        // Printing short value prints the 'actual expected value'
        System.out.println("Short value = " + maxValue + Byte.MIN_VALUE + Byte.MAX_VALUE);

        // Printing byte value shows maximum value overflowed.
        System.out.println("Byte value = " + s2);

    }
}