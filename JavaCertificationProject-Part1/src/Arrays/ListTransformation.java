package Arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
Section 5: Working with Java Arrays
Topic: 5. Using List Transformation methods
Arrays.SetAll, List.of,list.subList(startIndex,endIndex),list.toArray(object Array)
iterator (hasNext), listIterator (hasNext,hasPrevious), List.toString,Arrays.toString
 */
public class ListTransformation {
    public static void main(String[] args) {

        // Create a new Integer array
        Integer[] integerArray = new Integer[10];
        // Set values to 1 - 10
        Arrays.setAll(integerArray, (index) -> index + 1);

        System.out.println("integerArray values are " + Arrays.toString(integerArray));

        List anotherList = List.of(integerArray);
        // Create a subList of a list
        List subList = anotherList.subList(3,7);
        System.out.println("subList values are "+subList.toString());

        // And now go from List to array.......
        Integer[] repeatedArray = new Integer[10];
        anotherList.toArray(repeatedArray);
        System.out.println("Array created from toArray() :  "+Arrays.toString(repeatedArray));

        System.out.println("------- iterator tests -----------");
        // Iterator allows forward processing of list elements
        System.out.println("loop through anotherList.iterator() values....");
        for (Iterator it = anotherList.iterator();it.hasNext();){
            System.out.println(it.next());
        }

        // Iterator allows backwards and forwards processing of list elements
        System.out.println("loop through anotherList.listIterator() values....");
        ListIterator lit = anotherList.listIterator();
        for (int i = 0 ;lit.hasNext(); i++){
            System.out.println(lit.next());
            if(i == 4){
                System.out.println("\n reverse direction");
                for (;lit.hasPrevious();){
                    System.out.println(lit.previous());
                }
                break;
            }
        }
    }
}
