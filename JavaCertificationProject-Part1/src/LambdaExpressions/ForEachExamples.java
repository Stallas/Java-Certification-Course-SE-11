package LambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/*
Section 10: Programming Abstractly TThrough Interfaces
Topic: Lambda Expressions
Sub-Topic: 4.Using ArrayLists with Lambda Expressions.
 */
public class ForEachExamples {
    /*
    We will create a method that will set values in the String Array.
    The parameter is the array index.
    A_TEST_1, B_TEST_2 etc.
     */
    public static String setValue(int index){
        int intA = 65;
        int multiplier = index / 26;
        int cntr = index - (multiplier * 26);
        return ((char) (cntr + intA)) + "_TEST_" + (index + 1);
    }
    // Main method creates array, calls setValue Method with Arrays.setALL method
    public static void main(String[] args) {

        // Initialise a String array
        String[] stringArray = new String[50];

        /*
        We will use Lambda expression method reference to set the data in the array.
        The method reference replaced an expression that would have been:
        (s) -> setValue(s) was replaced with ForEachExamples::setValue
         */
        Arrays.<String>setAll(stringArray, ForEachExamples::setValue);

        // Make an ArrayList out of the array
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList(stringArray));
        System.out.println(aList + "\n");

        // We'll use the stream() method to mainpulate the list
        aList.stream().filter((Predicate<String>) (s) -> s.startsWith("A") || s.startsWith("B"))
                .forEach(System.out::println);
       System.out.println(aList.get(0).split("_")[2].compareTo(aList.get(1).split("_")[2]));
        
       aList.sort((a,b)->{
            return Integer.valueOf(b.split("_")[2]).compareTo(Integer.valueOf(a.split("_")[2]));
        });
        System.out.println("\n" + aList);

        aList.sort(Comparator.reverseOrder());
        aList.sort((a,b)->b.compareTo(a));
        System.out.println("\n" + aList);
    }
}
