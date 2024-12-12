package Inheritance.Polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 14. Utilize polymorphism to cast and call methods
    Sub-Topic: Array casting and generics.
 */
public class GenericCasts {
    // Just want a few classes to play with

    static class BaseClass{
        String name = "Base case";
        public String toString(){
            return getClass().getName();
        }
    }
    static class NextClass extends CastExtras.BaseClass {
        String name = "Next Base case";
    }
    public static void testIt(List<BaseClass> baseListParameter){
        System.out.println(baseListParameter);
    }

    public static void main(String[] args) {

        // New types
        // Create a arrayList and assign to arraylist variables
        ArrayList rawList = new ArrayList<>();
        // Declare a List variable;
        List aList;
        aList = rawList;

        // Typed generic lists
        // Create a typed ArrayList using Baseclass and assign to ArrayList variable.
        ArrayList<BaseClass> baseList = new ArrayList<>();
        List<BaseClass> bList;
        bList = baseList;

        // Add a NextClass object to the raw ArrayList
        rawList.add(new NextClass());
//        baseList.add(new NextClass());

    }
}
