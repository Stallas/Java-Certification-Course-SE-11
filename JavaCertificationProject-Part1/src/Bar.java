/*
Topic:  Declare and initialize Local Variables
Sub-Topic: Initialization of  primitive data type variables - including default values.
* */
public class Bar {

    // Default values for numeric static variables set to a representation of 0
    static byte staticBarByte;
    static char staticBarChar;
    static short staticBarShort;
    static int staticBarInt;
    static long staticBarLong;
    static float staticBarFloat;
    static double staticBarDouble;
    // Default value for boolean static variables set to false;
    static boolean staticBarBoolean;

    // Default values for numeric instance variables set to a representation of 0
    byte barByte;
    char barChar;
    short barShort;
    int barInt;
    long barLong;
    float barFloat;
    double barDouble;
    // Default value for boolean instance variables set to false;
    boolean barBoolean;
    static String type = "this";

    public static void main(String[] args) {
        Bar bar = new Bar();
        String type = "hello";

        // These class variable references do not produce compile errors
        System.out.println("----------Class Variables set to default values----------");
        System.out.println(staticBarChar);
        System.out.println(Bar.staticBarBoolean);
        System.out.println(Bar.staticBarByte);

        // These class variable references do not produce compile errors
        System.out.println("----------Instance Variables set to default values----------");
        System.out.println(bar.barByte);
        System.out.println(bar.barBoolean);
        System.out.println(type);
        System.out.println(bar.type);
    }
}
