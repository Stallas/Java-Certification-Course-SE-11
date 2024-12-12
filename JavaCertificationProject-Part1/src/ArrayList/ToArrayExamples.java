package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Section 10: Programming Abstractly through Interfaces
Topic: Declare and Use List and ArrayList instances
Sub-Topic: 3.Exploring toArray() method
Cast required when no parameter passed or different parameter passed.
 */
public class ToArrayExamples {
    public static void main(String[] args) {

        // testValue will be used to access a single value in returned array
        int testValue = 0;

        // This is a generically typed ArrayList, passing Integer as the parameterized type.
        ArrayList<Integer> intList = new ArrayList<>(List.of(1,2,3,4,5));

        // This is a raw type ArrayList
        ArrayList rawList = new ArrayList(List.of(1,2,3,4,5));

        // Set up the parameter we will pass to the toArray() method
        Integer[] aIntArray = new Integer[10];

        System.out.println("--- All tests executed with lists that contain: "+ rawList + "------");
        System.out.println("\nScenario 1: Parameter is reference variable for Integer[10], elements all null");

        /*
        Scenario 1: array.length >= list.size(); and array elements initialized to null.
        This method toArray([]<T>) populates the passed array with as many elements as list
        contains and returns passed array back.
        No new array is created. Casting is reqd in case of rawList.
         */
        var bInt = intList.toArray(aIntArray);
        System.out.println("Result type from ArrayList<Integer> assigned to var = "+
                bInt.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(bInt));

        // No casting required.
        testValue = bInt[0];
        System.out.println("--- No cast required at individual level : the first element is "+ testValue);

        /*
        Reset the array we use as a parameter between tests, so tests between raw ArrayList and
        generic ArrayList are same.
         */
        aIntArray = new Integer[10];

        /*
        A raw ArrayList will still return array passed, in this case aIntArray reference.
         */
        var bRaw = rawList.toArray(aIntArray);
        System.out.println("Result type from ArrayList assigned to var = "+
                bRaw.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(bRaw));

        // Casting required.
        testValue = (int) bRaw[0];
        System.out.println("--- Cast required at individual level: the first element is "+testValue);
        System.out.println("\nScenario 2: Parameter is reference variable for Integer[10], elements all null");

        /*
        Scenario 2: array.length > list.size();and array elements initialized not null.
        This method toArray([]<T>) populates the passed array with as many elements as list
        contains and has one other, maybe unexpected behavioural twist.
        It sets the element at list.size() to null,
        leaving all other elements at indices > list.size() as they were.
         */
        aIntArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        Integer[] cInt = intList.toArray(aIntArray);
        System.out.println("Result type from ArrayList<Integer> assigned to Integer[] = "+
                cInt.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(cInt));

        // No casting required.
        testValue = cInt[0];
        System.out.println("--- No cast required at individual level : the first element is "+ testValue);

        // Reset the array we use as a parameter between tests, so tests between the Arraylist
        // and generic ArrayList are same.
        aIntArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        /*
        A raw ArrayList will still return array passed, in this case aIntArray reference,
        but to assign it to an Integer[] array we must cast.
         */
        Integer[] cRaw = (Integer[]) rawList.toArray(aIntArray);
        System.out.println("Result type from ArrayList assigned to Integer[] required casting = "+
                cRaw.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(cRaw));

        // No casting required
        testValue = cRaw[0];
        System.out.println("--- No cast required at individual level : " +
                "Since we cast entire array to (integer[]): the first element = "+ testValue);

        System.out.println("\nScenario 3: No parameter passed");
        /*
        Scenario 3: no parameter
        The method toArray() populates a newly instantiated Object[] array
        with the list's elements, which happen to all be Integer.
        The behavior is same for both rawList and generic List.
        Casting will be required when you access its individual elements.
         */
        Object[] dInt = intList.toArray();// CANNOT cast to (Integer[])
        // Code compiles but leads to ClassCastException.
//        Integer[] dInt = (Integer[]) intList.toArray();
        System.out.println("Result type from ArrayList<Integer> assigned to Object[] = "+
                dInt.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(dInt));

        // Casting required.
        testValue = (int) dInt[0];
        System.out.println("--- Cast required at individual level : the first element is "+ testValue);

        Object[] dRaw = rawList.toArray();
        System.out.println("Result type from ArrayList<Integer> assigned to Object[] = "+
                dRaw.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(dRaw));

        // Casting required.
        testValue = (int) dRaw[0];
        System.out.println("--- Cast required at individual level : the first element is "+ testValue);

        System.out.println("\nScenario 4: Array passed is too small");
        /*
        Scenario 4: array.length < list.size(); and array is initialised to null or
        otherwise the method toArray() populates a newly instantiated array of the same type
        as the parameter passed, and the size of the list itself, not the parameter passed.
         */
        aIntArray = new Integer[3];
        // Let's make no assumptions about what is returned....
        var eInt = intList.toArray(aIntArray);
        System.out.println("Result type from ArrayList<Integer> assigned to var = "+
                eInt.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(eInt));

        // No Casting required.
        testValue = eInt[0];
        System.out.println("--- No Casting required at individual level : the first element is "+ testValue);

        // Reset the array we use as a parameter between tests, so tests between the Arraylist
        // and generic ArrayList are same.
        aIntArray = new Integer[3];

        /*
        A raw ArrayList will still return Integer[] array
         */
        var eRaw = rawList.toArray(aIntArray);
        System.out.println("Result type from ArrayList assigned to Integer[] required casting = "+
                eRaw.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(eRaw));

        // Casting required
        testValue = (int) eRaw[0];
        System.out.println("--- Casting required at individual level : " +
                "the first element = "+ testValue);

        System.out.println("\nScenario 5: Array passed is now Number[] and not a reference to array passed");
        /*
        Scenario 5: array.length < list.size(); and no reference to array passed
        the method toArray() populates a newly instantiated array of the same type as the
        parameter passed and the size of the list itself, not the paramter passed.
         */
        var fInt = intList.toArray(new Number[0]);
        System.out.println("Result type from ArrayList<Integer> assigned to var = "+
                fInt.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(fInt));

        //  Casting required.
        testValue = (int) fInt[0];
        System.out.println("--- Casting required at individual level : the first element is "+ testValue);

        // A raw ArrayList will still return a Number[] array.
        var fRaw = rawList.toArray(new Number[0]);
        System.out.println("Result type from ArrayList<Integer> assigned to var = "+
                fRaw.getClass().getTypeName());
        System.out.println("--- Resulting array elements = "+Arrays.toString(fRaw));

        //  Casting required.
        testValue = (int) fRaw[0];
        System.out.println("--- Casting required at individual level : the first element is "+ testValue);





    }
}
