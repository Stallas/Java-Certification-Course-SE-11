package ArrayList;

import java.util.*;

/*
Section 10: Programming Abstractly through Interfaces
Topic:4. Declare and Use List and ArrayList instances
 */
public class ArrayListExample {
    public static void main(String[] args) {

        ArrayList<String> firstArray = new ArrayList<>(List.of("ABC","DEF","GHI","JKL","MNO"));
        ArrayList<String> secondArray = new ArrayList<>(List.of("ABC","DEF","GHI","JKL","MNO"));
        ArrayList<String> thirdArray = new ArrayList<>();

        // isEmpty() returns true if there are no elements in the array.
        System.out.println("thirdArray.isEmpty() : "+thirdArray.isEmpty());

        //.equals returns true if elements are equal
        System.out.println("firstArray.equals(secondArray) :"+firstArray.equals(secondArray));

        //.contains() returns true if element values are equal
        System.out.println("firstArray.contains(\"DEF\") :"+firstArray.contains("DEF"));
        System.out.println("firstArray.contains(\"ZZZ\") :"+firstArray.contains("ZZZ"));

        //.containsAll must find all elements in the list, order does not matter.
        System.out.println("firstArray.containsAll(List.of(\"ZZZ\",\"ABC\")) :"+firstArray.containsAll(List.of("ZZZ","ABC")));
        System.out.println("firstArray.containsAll(List.of(\"DEF\",\"ABC\")) :"+firstArray.containsAll(List.of("DEF","ABC")));

        //.indexOf returns -1 if element not found or the index of the element if found.
        System.out.println("firstArray.indexOf(\"DEF\") :"+firstArray.indexOf("DEF"));
        System.out.println("firstArray.indexOf(\"ZZZ\") :"+firstArray.indexOf("ZZZ"));

        //.lastIndexOf returns -1 if element not found or the index of the element if found.
        System.out.println("firstArray.lastIndexOf(\"DEF\") :"+firstArray.lastIndexOf("DEF"));
        System.out.println("firstArray.lastIndexOf(\"ZZZ\") :"+firstArray.lastIndexOf("ZZZ"));

        // subList returns a reduced List, using starting index, and ending index.
        System.out.println("firstArray.subList(2,4) : "+firstArray.subList(2,4));

        Iterator forwardIt = firstArray.iterator();
        while (forwardIt.hasNext()){
            System.out.println(forwardIt.next()+ " ");
        }

        // The ListIterator allows you to specify a starting index
        ListIterator traverseIt = firstArray.listIterator(2);
        if (traverseIt.hasNext())
            System.out.println("traverseIt.next() : "+traverseIt.next());

        // Reset ListIterator for example
        traverseIt = firstArray.listIterator(2);
        if (traverseIt.hasPrevious())
            System.out.println("traverseIt.previous() : "+traverseIt.previous());
    }
}
