package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic:6. Comparing Strings
 */
public class StringComparison {
    public static void main(String[] args) {

        // We'll create some String objects to test..
        String nullString = null;
        String stringHello1 = "Hello"; // String Literal, interned

        // String reference, not interned
        String stringHello = new String(new char[]{'h','e','l','l','o'});

        /* StringBuilder implements charSequence, we'll test String
        Comparison methods with alternate objects */
        StringBuilder helloStringBuilder = new StringBuilder("Hello");

        String firstString = stringHello;
        String secondString = stringHello1;
        Object secondObject = secondString;

        CharSequence secondSequence = secondString;

        // == Operand
        TestEqualsOperand(firstString,secondString);

//        public boolean equals(Object object)
        TestEqualsMethod(firstString,secondString);

        TestEqualsIgnoreCaseMethod(firstString, secondString);

        TestContentEqualsMethod(firstString, secondString);

        TestCompareToMethod(firstString, secondString);
        TestCompareToIgnoreCaseMethod(firstString, secondString);
    }
    /*
        == Operand . returns true when both objects refer to the same object, not the same value.
     */
    public static void TestEqualsOperand(String firstString, String secondString) {
        System.out.println(String.format("(%s == %s) =  " + (firstString == secondString),
                firstString,secondString));
    }
    /*
       public boolean equals(Object anObject)
       returns true if references are the same , or if the parameter type is string ans the value is same.
    */
    public static void TestEqualsMethod(String firstString, String secondString) {
        try{
            System.out.println(String.format("%s.equals(%s) = " + (firstString.equals(secondString)),
                    firstString,secondString));
        }
        catch (Exception e){
            System.out.println(String.format(" Error occurred with %s.equals(%s) = " +
                    firstString,secondString,e.getClass().getName()));
        }
    }
    /*
       public boolean equalsIgnoreCase(Object anObject)
       returns true if two strings have same value ignoring case
    */
    public static void TestEqualsIgnoreCaseMethod(String firstString, String secondString) {
        try{
            System.out.println(String.format("%s.equalsIgnoreCase(%s) = " + (firstString.equalsIgnoreCase(secondString)),
                    firstString,secondString));
        }
        catch (Exception e){
            System.out.println(String.format("Error occurred with %s.equalsIgnoreCase(%s) = " +
                    firstString,secondString,e.getClass().getName()));
        }
    }
    /*
       public boolean contentEquals(Charsequence cs)
       returns true if values in String and the second passed parameter are the same.
    */
    public static void TestContentEqualsMethod(String firstString, String secondString) {
        try{
            System.out.println(String.format("%s.contentEquals(%s) = " + (firstString.contentEquals(secondString)),
                    firstString,secondString));
        }
        catch (Exception e){
            System.out.println(String.format("Error occurred with %s.contentEquals(%s) = " +
                    firstString,secondString,e.getClass().getName()));
        }
    }
    /*
       public int compareTo(String  anotherString)
       Compares the value of strings lexicographically
    */
    public static void TestCompareToMethod(String firstString, String secondString) {
        try{
            System.out.println(String.format("%s.compareTo(%s) = " + (firstString.compareTo(secondString)),
                    firstString,secondString));
        }
        catch (Exception e){
            System.out.println(String.format("Error occurred with %s.compareTo(%s) = " +
                    firstString,secondString,e.getClass().getName()));
        }
    }
    /*
       public int compareToIgnoreCase(String  anotherString)
       Compares the value of strings lexicographically
    */
    public static void TestCompareToIgnoreCaseMethod(String firstString, String secondString) {
        try{
            System.out.println(String.format("%s.compareToIgnoreCase(%s) = " + (firstString.compareToIgnoreCase(secondString)),
                    firstString,secondString));
        }
        catch (Exception e){
            System.out.println(String.format("Error occurred with %s.compareToIgnoreCase(%s) = " +
                    firstString,secondString,e.getClass().getName()));
        }
    }
}
