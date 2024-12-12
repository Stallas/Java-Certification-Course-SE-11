package Arrays;

import java.util.Arrays;

/*
Section 5: Working with Java Arrays
Topic:1. Single Dimensional Array
check references
 */
public class ArraysFirstExample {
    public static void main(String[] args) {
        // Create 2 arrays, one of Integer, one of int.
        // elements initialised to null.
        Integer[] integerArray = new Integer[5];
        // elements initialised to 0.
        int[] intArray = new int[5];

        // Arrays.toString() prints elements as comma delimited String
        System.out.println("------Default Values--------");
        System.out.println("intArray : "+ Arrays.toString(intArray));
        System.out.println("integerArray : "+ Arrays.toString(integerArray));

        // loop condition uses length attribute of one of the arrays.
        for(int i = 0; i < intArray.length; i++){
            // set data on arrays, autoboxing occurs for integerArray
            integerArray[i] = intArray[i] = (i + 1);
        }
        System.out.println("\n------Values after the loop--------");
        System.out.println("intArray : "+ Arrays.toString(intArray));
        System.out.println("integerArray : "+ Arrays.toString(integerArray));

        // Access a single element in an array
        intArray[2] = 10;
        integerArray[0] = 99;

        System.out.println("\n------ Final Values--------");
        System.out.println("intArray : "+ Arrays.toString(intArray));
        System.out.println("integerArray : "+ Arrays.toString(integerArray));

        // Create new int[] variable reference and assign it intArray
        int[] intArray2 = intArray;
        // Create new Integer[] variable reference and assign it integerArray
        Integer[] integerArray2 = integerArray;

        System.out.println("\n------ Final Values--------");
        System.out.println("intArray : "+ Arrays.toString(intArray));
        System.out.println("integerArray : "+ Arrays.toString(integerArray));

        System.out.println("\n------ Print Arrays --------");
        System.out.println("intArray : "+ Arrays.toString(intArray2));
        System.out.println("integerArray : "+ Arrays.toString(integerArray2));

        // make a change to data on first array references
        intArray[0] = 55;
        integerArray[0] = 66;
        // make a change to data on second array references
        intArray2[1] = 77;
        integerArray[1] = 88;

        System.out.println("\n------ Print Arrays Values--------");
        // You can see both references show the data changes
        System.out.println("intArray : "+ Arrays.toString(intArray));
        System.out.println("integerArray : "+ Arrays.toString(integerArray));
        System.out.println("intArray : "+ Arrays.toString(intArray2));
        System.out.println("integerArray : "+ Arrays.toString(integerArray2));


        // quiz
        int[] aArray = new int[3];
        Integer[] bArray = new Integer[3];
        aArray[2] = 1;
        bArray[0] = 1;

        for (int a :aArray){
            System.out.println(a + " ");
        }
        for (int b :bArray){// leads to Null Pointer exception
            System.out.println(b + " ");
        }
        /*
        Elements in bArray are never initialised , so if you try to loop through it and use auto unboxing
        in the for loop to assign a value to an int, this will throw a nullptrException.
        If you changed 2nd for loop to for(Integer b:bArray) or for(var b:bArray),no such error would occur.
         */

    }
}
