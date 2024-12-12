package Arrays;

import java.util.Arrays;

/*
Section 5: Working with Java Arrays
Topic: 7. Out of Ordinary
Ways to initialize array with values by assigning Integer,int i.e. autoboxing
Mismatch,equals,compare works only for same input type but mismatch,equals works for Number,Integer
 */
public class ArrayExtras {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        // You can assign an int variable to long
        long myLong = a;
        System.out.println("myLong = "+myLong);

        // And you can do this...
        long[] longArray = {0,1,2,3,4};
        System.out.println("longArray = "+ Arrays.toString(longArray));

        // And this..
        long[] myLongArray = new long[2];
        myLongArray[0] = a;
        myLongArray[1] = b;
        System.out.println("myLongArray = "+ Arrays.toString(myLongArray));

        // And you know you can do this.. Java autoboxes
        Integer aInteger = a;
        Integer bInteger = b;
        System.out.println("aInteger "+aInteger);

        Integer[] integerArray = {0,1,2,3,4};
        System.out.println("integerArray : "+Arrays.toString(integerArray));

        // You can mix and match Integer, int here
        Integer[] myIntegerArray = new Integer[2];
        myIntegerArray[0] = aInteger;
        myIntegerArray[1] = b;
        System.out.println("myIntegerArray : "+Arrays.toString(myIntegerArray));

        // Here, Array methods such as mismatch, equals, compare works only for same input object.
//        Long[] newLongArray = new int[2];
//        Integer[] newIntegerArray = new int[2];

        int[] intArray = {0,1,2,3,4};
//        int mismatchedIndex = Arrays.mismatch(intArray,integerArray);
//        boolean isSame = Arrays.equals(intArray,integerArray);
//        int compared = Arrays.compare(intArray,integerArray);

        System.out.println("\n---- Test method with common super class ");
        Number[] myNumberArray = {1,2,3,4};
        int mismatchedIndex = Arrays.mismatch(myNumberArray,integerArray);
        boolean isSame = Arrays.equals(myNumberArray,integerArray);
//        int compared = Arrays.compare(myNumberArray,integerArray);

        System.out.println("mismatchedIndex : "+mismatchedIndex);
        System.out.println("isSame : "+isSame);

    }
}
