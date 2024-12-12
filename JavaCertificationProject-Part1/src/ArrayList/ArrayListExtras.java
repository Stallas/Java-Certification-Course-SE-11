package ArrayList;
/*
Section 10: Programming Abstractly through Interfaces
Topic:5. Declare and Use List and ArrayList instances
Sub-Topic: ArrayList review
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExtras {
    public static class BaseClass{
        private String name;
        BaseClass(String name){
            this.name = name;
        }
        public String toString(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
    public static void main(String[] args) {
        ArrayList<BaseClass> typedList = new ArrayList<>();
        ArrayList rawList = new ArrayList();

        // add without an index, adds an element to the end of the list
        typedList.add(new BaseClass("abc"));

        // add with an index, adds element at the index
        typedList.add(0,new BaseClass("bcd"));
        typedList.add(0,new BaseClass("cde"));

        // Add elements to rawList,note that we can access all elements in typedList as a BaseClass
        for (BaseClass b:typedList) {
            // We'll make copies of the baseclass objects and add
            rawList.add(0,new BaseClass(b.toString()));
        }
        System.out.println("typedList = " + typedList);
        System.out.println("rawList = " + rawList);

        /*
        Can we do this in a typedList without casting.
        setName() is method on BaseClass
         */
        typedList.get(2).setName("ccc");
        // Trying the same thing on object from raw ArrayList is a bit uglier.
        ((BaseClass)(rawList.get(0))).setName("aaa");

        // You can add an element at an index that is one larger than the # of elements
        typedList.add(typedList.size(),new BaseClass("def"));
        System.out.println("typedList = " + typedList);
        System.out.println("rawList = " + rawList);

        // You cannot set an element at an index that is one larger than the # of elements
//        typedList.set(typedList.size(),new BaseClass("def"));// IndexOutOfBoundException
//        typedList.add(typedList.size()+1,new BaseClass("def"));
        System.out.println("typedList = " + typedList);
        System.out.println("rawList = " + rawList);

        // Next, we create a typedList which we'll try to add to our ArrayLists.
        List<BaseClass> typedSubList = List.of(new BaseClass("efg"),
                new BaseClass("fgh"),new BaseClass("hij"));

        // You can add a collection at an index that is one larger than # of elements
        typedList.addAll(typedList.size(),typedSubList);

        // Typed ArrayList catches mistakes at compile time.. Maybe you forgot that set does mean setAll
//       typedList.set(0,typedSubList);
//        typedList.set(0, (BaseClass) typedSubList); // leads to classCastException
        rawList.set(0,typedSubList);
        System.out.println("typedList = " + typedList);
        System.out.println("rawList = " + rawList);

        ArrayList<BaseClass> newBaseList = new ArrayList<>();
        newBaseList.add(0,new BaseClass("one"));

        ArrayList<BaseClass> newBaseListWithCapacity = new ArrayList<>(10);
        newBaseListWithCapacity.add(0,new BaseClass("one"));

        ArrayList<BaseClass> newBaseListWithSomeElements = new ArrayList<>(
                List.of(new BaseClass("one"),new BaseClass("two"))
        );

        newBaseListWithSomeElements.add(2,new BaseClass("three"));

        // subList can return a typedList if you specify it.
        List<BaseClass> typedSubList1 = typedList.subList(0,2);
        typedSubList1.get(0).setName("abc");
        // or alternatively subList returns a rawList
        List rawSubList1 = typedList.subList(0,2);
//        rawSubList1.get(0).setName("ABC");
    }
}
