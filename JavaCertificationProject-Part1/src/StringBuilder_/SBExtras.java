package StringBuilder_;

import java.util.Arrays;

/*
    Topic: Manipulate Data With StringBuilder
    Sub-Topic:5. Out of the Ordinary
    trimToSize(),replace,strip,getChars()
 */
public class SBExtras {
    public static void main(String[] args) {
        // Creates empty StringBuilder
        StringBuilder builder = new StringBuilder();

        // Add some code with leading/trailing whitespace
        builder.append("   ABCD   ");
        System.out.println("Original value of builder = "+ builder + "*");
        System.out.println("builder.length() = "+builder.length());
        System.out.println("builder.capacity() = "+builder.capacity());

        /* What do you think trimToSize does ?
        trimToSize() method of StringBuilder class is the inbuilt method
         used to trims the capacity used for the character sequence.
         i.e. it resizes if current capacity is larger enough to hold mmy efficient.
         */
        builder.trimToSize();
        System.out.println("Current value of builder = "+ builder + "*");
        System.out.println("builder.length() = "+builder.length());
        System.out.println("builder.capacity() = "+builder.capacity());

        builder.replace(0,builder.length(),builder.toString().strip());
        System.out.println("Next value of builder = "+ builder + "*");
        System.out.println("builder.length() = "+builder.length());
        System.out.println("builder.capacity() = "+builder.capacity());

        // Let's explore getChars method on String and StringBuilder
        // Test data

        builder.append(" just some more text because we need more text");
        char[] myCharacterArray1 = new char[10];
        char[] myCharacterArray2 = new char[10];

        // Calling getChars on a String with srcBegin = 20, srcEnd = 27
        builder.toString().getChars(20,27,myCharacterArray1,0);
        builder.toString().getChars(20,27,myCharacterArray2,0);

        System.out.println("myCharacterArray1 : "+Arrays.toString(myCharacterArray1));
        System.out.println("myCharacterArray2 : "+Arrays.toString(myCharacterArray2));

        // Set up some more test data
        char[] myCharacterArray3 = new char[builder.length()];
        char[] myCharacterArray4 = new char[builder.length()];

        // Calling getChars on a String with srcBegin = 20, srcEnd = 21
        builder.toString().getChars(20,21,myCharacterArray3,0);
        builder.toString().getChars(20,21,myCharacterArray4,0);

        System.out.println("myCharacterArray3 : "+Arrays.toString(myCharacterArray3));
        System.out.println("myCharacterArray4 : "+Arrays.toString(myCharacterArray4));

        // Set up additional data
        char[] myCharacterArray5 = new char[10];
        char[] myCharacterArray6 = new char[10];

        // Let's change the destination index from 0 to 3
        builder.toString().getChars(20,27,myCharacterArray5,3);
        builder.toString().getChars(20,27,myCharacterArray6,3);

        System.out.println("myCharacterArray5 : "+Arrays.toString(myCharacterArray5));
        System.out.println("myCharacterArray6 : "+Arrays.toString(myCharacterArray6));

        // StringIndexOutOfBoundsException
        char[] myCharacterArray7 = new char[5];
        char[] myCharacterArray8 = new char[5];

        // Let's change the destination index from 0 to 3
//        builder.toString().getChars(20,27,myCharacterArray7,3);
//        builder.toString().getChars(20,27,myCharacterArray8,3);

//        System.out.println("myCharacterArray7 : "+Arrays.toString(myCharacterArray7));
//        System.out.println("myCharacterArray8 : "+Arrays.toString(myCharacterArray8));

        // quiz
        StringBuilder sb = new StringBuilder(5);
        sb.append("abcdefghijklmn");
        char[] charArray;
        if("hello" == "hello")
            charArray = new char[5];
        builder.getChars(0,5,new char[5],0);// if charArray then output is abcde*
        System.out.println(new String(charArray).trim() + "*");

    }
}
