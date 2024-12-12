package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic: 12. Counting Strings
 */

public class StringCount {
    public static void main(String[] args) {

        String stringOriginal = "aaabbb";

        /*
        Thia behaviour is the same for all the replace methods.
        If there is NO match, a new string is NOT created.
         */
        String stringReplaced = stringOriginal.replace('C','a');
        System.out.println("1. replace char (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        stringReplaced = stringOriginal.replace("CC","aa");
        System.out.println("2. replace String literal (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        stringReplaced = stringOriginal.replaceAll("CC","aa");
        System.out.println("3. replace all (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        stringReplaced = stringOriginal.replaceFirst("CC","aa");
        System.out.println("4. replace first (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        /*
        The replace method with two chars that are the same does not create a new string object
         */
        stringReplaced = stringOriginal.replace('a','a');
        System.out.println("5. replace (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));
         /*
        The replace method with String parameters exhibits different behaviour than the one that accepts chars.
         */
        stringReplaced = stringOriginal.replace("a","a");
        System.out.println("6. replace (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        stringReplaced = stringOriginal.replaceAll("a","a");
        System.out.println("7. replaceAll (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        stringReplaced = stringOriginal.replaceFirst("a","a");
        System.out.println("8. replaceFirst (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        /*
        Note that creating a substring which is same as string does NOT create a new Object.
         */
        stringReplaced = stringOriginal.substring(0,stringOriginal.length());
        System.out.println("9. substring (stringReplaced == stringOriginal) " +
                (stringReplaced == stringOriginal));

        /*
        Compiler calculates this expression to the constant "abc:def" so only one string
        is created at runtime on this line
         */
        String s1 = "abc" + ":" + "def";

        // Set up some more strings for next examples
        String s2 = "s2";
        String s3 = "s3";
        String s4 = "s4";

        /*
        The following statement creates 3 string objects.
        object1 = s2 + s1
        Object2 = s3 + object1
        Object3 = s4 + object2
        If we rewrite this as s5 = (((s4 + s3) + s2) + s1)
        It might be easier to count the number of objects created by counting left parenthesis groupings
         */

        String s5 = s4 + s3 + s2 + s1;

    }
}
