package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic:5. Strings and the Compound concatenation operator
 */
public class StringCompoundConcat {
    public static void main(String[] args) {
        String helloString = "hello";
        String worldString = " world";

        // Use the compound concatenator on string literals
        String compoundString = "hello";
        compoundString += " World";
        System.out.println("compoundString = "+compoundString);

        // Use the compound concatenator on string Objects
        String compoundString2 = helloString;
        compoundString2 += worldString;
        System.out.println("compoundString2 = "+compoundString2);

        // Use a null String on the left
        String nullString = null;
        nullString += helloString;
        System.out.println("nullString = "+nullString);

        // Use a null String on the right
        nullString = null;
        String compoundStringWithNull = helloString;
        compoundStringWithNull += nullString;
        System.out.println("compoundStringWithNull = "+compoundStringWithNull);

        // String concatenation when right hand object is not a String, but is a CharSequence
        Object charSeqObj = new StringBuffer("testing");
        String compoundString3 = "charSequenceObject";
        compoundString3 += charSeqObj;
        System.out.println("compoundString3 =" + compoundString3);

        // String concatenation when left hand object is not a String, but is a CharSequence
        charSeqObj = new StringBuffer("testing");
        charSeqObj += helloString;
        System.out.println("charSeqObj =" + charSeqObj);

        // String concatenation when right hand object is not a String, CharSequence. We created ImmutableString
        Object someOtherObj = new ImmutableString();
        String compoundString4 = "object ";
        compoundString4 += someOtherObj;
        System.out.println("compoundString4 =" + compoundString4);

        // String concatenation when left hand object is not a String,We created Immutable String
        someOtherObj = new ImmutableString();
        someOtherObj += helloString;
        System.out.println("someOtherObj =" + someOtherObj);
        System.out.println("someOtherObj.toString() =" + someOtherObj.toString());

        int anInt = 100;
        // Valid...
        String compoundString5 = helloString;
        compoundString5 += anInt;
        System.out.println("compoundString5 =" + compoundString5);

        // Invalid..
//        anInt += helloString;
//        System.out.println("anInt = "+anInt);

        String mathString1 = "The value is ";
        mathString1 += 5 + 7;
        System.out.println("mathString1 = "+mathString1);//12

        String mathString2 = "The value is ";
        mathString2 = mathString2 + 5 + 7;
        System.out.println("mathString2 = "+mathString2);//57

        /* Adding parenthesis when expanding out the compound concatenation operator fixes the issue,
         so the right hand operator of the compound concatenation operator is wrapped
        with an implied parenthesis set
         */
        String mathString3 = "The value is ";
        mathString3 = mathString3 + (5 + 7);
        System.out.println("mathString3 = "+mathString3);

    }
}
