package String_;

import javax.print.attribute.standard.MediaSize;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
    Topic: Create and Manipulate Strings
    Sub-Topic:3. Creating String
 */
public class StringConstructor {
    public static void main(String[] args) {
        int alphabet_len = 26;
        char[] charArray = new char[alphabet_len];
        int[] intArray = new int[alphabet_len];
        byte[] byteArray = new byte[alphabet_len];

        int i = 0;
        for(char c='a';c <= 'z';c++,i++){
            /* Creating a charArray, intArray, byteArray using english characters and casting*/
            charArray[i] = c;
            intArray[i] = (int) c;
            byteArray[i] = (byte) c;
        }
        System.out.println("charArray = "+ Arrays.toString(charArray));
        System.out.println("intArray = "+Arrays.toString(intArray));
        System.out.println("byteArray = "+Arrays.toString(byteArray));

        // Creating a String from Character Array
        String charString = new String(charArray);
        System.out.println("charString = "+charString);

        // Creating a String from Byte Array
        String byteString = new String(byteArray);
        System.out.println("byteString = "+byteString);

        /* Creating s String from Integer Array
        Note here : We cannot create a string with integer array with a simple one args constructor
        so we'll use offset = 0 and length = the length of array, to get full alphabet
         */
        String intString = new String(intArray,0,alphabet_len);
        System.out.println("intString = "+intString);

        // Create a String from the character array
        int offset = 1;
        String charString2 = new String(charArray,offset,alphabet_len - offset);
        System.out.println("charString2 = "+charString2);

        // Only want f-j now.
        offset = 5;
        int length = 5;
        String intString2 = new String(intArray,offset,length);
        System.out.println("intString2 = "+intString2);

        offset = 2;
        length = 9;
        // Creating a String from Byte Array
        String byteString2 = new String(byteArray,offset,length, StandardCharsets.ISO_8859_1);
        System.out.println("byteString2 = "+byteString2);


    }
}
