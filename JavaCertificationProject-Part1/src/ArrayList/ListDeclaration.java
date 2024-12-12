package ArrayList;

import java.util.ArrayList;
import java.util.List;

/*
Section 10: Programming Abstractly Through Interfaces
Topic: 1. Declare and Use List and ArrayList instances;
Sub-Topic: Declaration Examples
add(with/without index),addAll(with/without index),replaceAll(using replace),
remove,removeIf,removeAll(List.of),retainAll(List.of),forEach
 */
public class ListDeclaration {
    public static void main(String[] args) {

        // List variable declarations
        List l;
        List<Integer> intList;
        List<ArrayList> arrayList;

        // ArrayList variable declarations
        ArrayList  a;
        ArrayList<Integer> integerArray;
        ArrayList<String> stringArray;

        // Instantiation of ArrayList object
        // Initialize a non-typed ArrayList using no-args constructor.
        a = new ArrayList<>();

        // Initialize the String-typed ArrayList using int argument
        // which sets the initial capacity of the ArrayList.
        stringArray = new ArrayList<String>(10);

        // Initialize the Integer-typed ArrayList using the Collections
        // parameter which passes values to the ArrayList.
        integerArray = new ArrayList<>(List.of(10,20,30));

        // You can leave the type out of the right hand set of <>
        ArrayList<String> abc = new ArrayList<>();

        // This generates a warning but compile
        ArrayList<String> def = new ArrayList<>();

        // You cannot create List object but you can set objects
        // that implement List to a List variable.
        l = a;
        intList = integerArray;

        // add some data
        for(int i = 0; i < 5; i++){
            // adds data at the end of list...
            stringArray.add("String_"+(i+1));
            integerArray.add(i + 1);
        }
        System.out.println(stringArray);
        System.out.println(integerArray);

        // add some data at certain index, here shifting of array takes place.
        for (int i = 0; i < 5; i++){
            // adds data at the end of list...
            stringArray.add(1,"String_"+(i+1));
            integerArray.add(1,i + 1);
        }
        System.out.println(stringArray);
        System.out.println(integerArray);

        // addAll adds a collection of data, this call appends data to the end of list.
        integerArray.addAll(List.of(15,25,35));
        System.out.println(integerArray);

        // addAll adds a collection of data, this call inserts all elements of the list
        // starting at the index, moving existing elements to a higher index location.
        integerArray.addAll(1,List.of(150,250,300));
        System.out.println(integerArray);

        /*
        remove a single element, and only the first match, using remove method
         */
        stringArray.remove("String_5");
        System.out.println("StringArray after removing "+stringArray.toString());

        // Remove a matching element
        stringArray.removeIf(s -> s.contains("_2"));
        System.out.println("StringArray after removing a matching element "+stringArray.toString());

        // Replace values in the array using a lambda expression
        stringArray.replaceAll((s)->s.replace("String_","Test_"));
        System.out.println("StringArray after replaceAll "+stringArray.toString());

        // put them back the way they were...
        stringArray.replaceAll((e)->e.replace("Test_","String_"));

        /*
        Remove a set of elements using removeAll method.
        Note that the list you pass removeAll may contain elements that
        are not in stringArray. It will remove matched elements.
         */
        stringArray.removeAll(List.of("String_1","String_3","String_10"));
        System.out.println("StringArray after removing several elements "+stringArray.toString());

        // Keep only a defined set of elements using ArrayList.retainAll
        stringArray.retainAll(List.of("String_4"));
        System.out.println("StringArray after retaining only String_4 "+stringArray.toString());

        // Print String objects in the List using forEach
        stringArray.forEach( (e)->System.out.println(e));

    }
}
