package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic: 10. Text Transform
 */
public class TextTransform {
    public static void main(String[] args) {

        // Ex of: repeat(int count) introduced in Java 11 Returns a String

        // We'll repeat the String 3x, set count parameter = 3
        String repeatString = "Repeat after me ";
        repeatString = repeatString.repeat(3);
        System.out.println("repeatString = "+repeatString);

        // But what does passing a zero does ? It returns empty String
        repeatString = repeatString.repeat(0);
        System.out.println("repeatString = "+repeatString);

        // -----------ValueOf methods---------

        // Ex of: valueOf(char[] data)
        String charToString = String.valueOf(new char[]{'h','e','l','l','o'});
        // valueOf(char[] data, int offset, int count)
        String charToStringPartial = String.valueOf(new char[]{'h','e','l','l','o'},1,3);
        String substring = charToString.substring(1,3);

        System.out.println("charToString = "+charToString);
        System.out.println("charToStringPartial = "+charToStringPartial);
        System.out.println("substring = "+substring);


    }
}
