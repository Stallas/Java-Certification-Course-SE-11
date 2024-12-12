package Arrays;

import java.util.Arrays;
import java.util.List;

/*
Section 5: Working with Java Arrays
Topic:3. Search with Arrays.
binarySearch,mismatch,contains,containsAll,indexOf,lastIndexOf
 */
public class ArraySearch {
    public static void main(String[] args) {
        // Set up some data for comparison
        String[] firstString = {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        String[] firstStringUnsortedDuplicates = {"jkl","mno","pqr","stu","vwx","yz","jkl","abc","def","ghi"};
        String[] partialFirstString = {"abc","def","ghi","jkl","mno"};

        // Create pass-thru Lists from arrays to test List equality
        List firstList = List.of(firstString);
        List secondList = Arrays.asList(firstStringUnsortedDuplicates);

        //binarySearch present 1 else 0 even if duplicates present
        System.out.println("-----Arrays.binarySearch------");
        // binary Search on array  , look for "jkl" which is present in array
        String searchString = "jkl";
        System.out.println(Arrays.binarySearch(firstString,searchString));

        // binary Search on array , look for "aaa" which is not present in array
        System.out.println(Arrays.binarySearch(firstString,"aaa"));
        // binary Search on unsorted array , look for "jkl" of which there are two elements
        System.out.println(Arrays.binarySearch(firstStringUnsortedDuplicates,"jkl"));
        // binary Search on unsorted array , look for "abc" which is in array
        System.out.println(Arrays.binarySearch(firstString,"abc"));

        System.out.println("-----Arrays.mismatch------");
        // mismatch returns the non-matching index where the prefix ends
        System.out.println(Arrays.mismatch(firstString,partialFirstString));
        System.out.println(Arrays.mismatch(firstString,firstStringUnsortedDuplicates));
        System.out.println(Arrays.mismatch(firstStringUnsortedDuplicates,new String[]{"jkl","mno"}));

        System.out.println("-----List methods------");
        // contains,containsAll returns boolean
        // Does the array contains "def" ?
        System.out.println("firstList.contains(\"def\")"+firstList.contains("def"));
        // Does the array contains elements in partialString?
        System.out.println(firstList.containsAll(Arrays.asList(partialFirstString)));

        // create a second list not in same order
        String[] anotherUnsortedSet = {"jkl","def","abc","ghi","mno"};
        System.out.println("firstList.containsAll(Arrays.asList(anotherUnsortedSet))"+
                firstList.containsAll(Arrays.asList(anotherUnsortedSet)));

        // Use indexOf to get the first matching element
        System.out.println("secondList.indexOf(\"jkl\")"+ secondList.indexOf("jkl"));

        // Use lastIndexOf to get the last matching element
        System.out.println("secondList.lastIndexOf(\"jkl\")"+secondList.lastIndexOf("jkl"));
    }
}
