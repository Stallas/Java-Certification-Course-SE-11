package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Section 5: Working with Java Arrays
Topic: 8. Out of Ordinary
Ways to initialize array ,changing subList reflects the original string array but isnt list
Various representation of toArray declarations.
*/
public class ArraysAndList {
    public static void main(String[] args) {
        String[] firstString = {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        List firstList = List.copyOf(Arrays.asList(firstString));
        List secondList = List.of(firstList);

        System.out.println("firstList : "+firstList.toString());
        System.out.println("secondList : "+secondList.toString());

        Object o = firstList.get(0);
        System.out.println(o.getClass().getName());
        o = secondList.get(0);
        System.out.println(o.getClass().getName());

        System.out.println("\n----------- subList example --------");
        List subList = Arrays.asList(firstString).subList(0,5);
        System.out.println("subList : "+ subList.toString());

        // Sort the subList
//        subList.sort(Collections.sort());
        subList.sort(Collections.reverseOrder());
        System.out.println("subList after reverse : "+ subList.toString());
        System.out.println("firstString array : "+ Arrays.toString(firstString));
        System.out.println("firstList : "+firstList.toString());

        // Now let's look at toArray
        System.out.println("\n------- toArray examples -----------");
        int arrayLength = firstList.size();// arrayLength changes results

        // Set up a new array which we will pass to toArray
        String[] aArray = new String[arrayLength];
        // Calling toArray without assigning returned array to a variable;
        firstList.toArray(aArray);
        System.out.println("aArray array :"+Arrays.toString(aArray));

        // Set up another new array which we will pass to toArray
        String[] bArray = new String[arrayLength];
        // Calling toArray assigning returned array to a variable;
        String[] nextArray = (String[])firstList.toArray(bArray);
        System.out.println("bArray array : "+Arrays.toString(bArray));
        System.out.println("nextArray array : "+Arrays.toString(nextArray));

        System.out.println("nextArray.equals(bArray) : "+nextArray.equals(bArray));

        System.out.println("\n----------Final toArray Examples----------");
        // If you always want an array that represents the elements exactly in the list,
        // You can pass a 0 length array
        String[] arrayRepresntation = (String[])firstList.toArray(new String[0]);
        System.out.println("arrayRepresntation : "+Arrays.toString(arrayRepresntation));

        // You can call toArray with no parameter, it returns as array of Object.
        Object[] objectArray = firstList.toArray();
        System.out.println("objectArray : "+Arrays.toString(objectArray));
        String[] newRepresntation = (String[]) objectArray; //.ClassCastException
        System.out.println("newRepresntation : "+Arrays.toString(newRepresntation));
    }
}
