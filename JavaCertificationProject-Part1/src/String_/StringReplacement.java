package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic:9. String replace and substring
 */
public class StringReplacement {
    public static void main(String[] args) {

        // creating variables
        String mississippi = "Mississippi";
        String[] resultArray = new String[4];

        // Ex of: replace(char oldChar, char newChar) returns a String
        resultArray[0] = "Replace of 's' with 'S' : "+mississippi.replace('s','S');

        // Ex of: replace(CharSequence oldChar, CharSequence newChar) returns a String
        resultArray[1] = "Replace literal \"iss\" with \"ips\" : "+
                mississippi.replace("iss","isp");

        // Ex of: replaceAll(String regex, String replacement) returns a String
        resultArray[2] = "Replace regex [i with 2 characters(s or p)] with literal" +
                "\"ax\": "+
                mississippi.replaceAll("(i(s|p){2})","ax");

        // Ex of: replaceFirst(String regex, String replacement) returns a String
        resultArray[3] = "Replace first match of regex [i with 2 characters(s or p)]" +
                "with literal \"ax\": "+
                mississippi.replaceFirst("(i(s|p){2})","ax");


        for (String res:resultArray) {
            System.out.println(res);
        }

        // .... substring and subsequence
        /*
            This call to substring extracts a substring ignoring any characters prior to index 7
         */
        System.out.println("mississippi.substring(7) "+mississippi.substring(7));

        /*
            This call to substring extracts a substring at index 3 and ending at index 7
         */
        System.out.println("mississippi.substring(3,7) "+mississippi.substring(3,7));
        /*
           subsequence can be used for both String and StringBuilder Objects.
           but both starting and ending index are required.
           The method subSequence() obtains a part of a String given the starting index and
           the length of the result. The method SubSequence() behaves in the same way as substring()..
           The only difference is that it returns a CharSequence instead of a String.

           String string = "Hello";

            String subString1 = string.substring(1,4);             // ell
            String subString2 = string.subSequence(1, 4);          // Type mismatch compiler error

            CharSequence subSequence1 = string.subSequence(1, 4);  // ell
            CharSequence subSequence2 = string.substring(1, 4);    // ell
         */
        CharSequence s = mississippi.subSequence(3,7);
        System.out.println("mississippi.subSequence(3,7) "+mississippi.subSequence(3,7));
        System.out.println("mississippi = "+mississippi);


        /*
            Reassigning output to the mississippi String reference type
         */
        mississippi = mississippi.substring(0,4);
        System.out.println("mississippi = "+mississippi);

    }
}
