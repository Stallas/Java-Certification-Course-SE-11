package Arrays;

import java.util.Arrays;
import java.util.List;

/*
Section 5: Working with Java Arrays
Topic:2. Comparing Arrays.
Arrays.compare,.compareTo,.equals
 */
public class ArrayComparison {
    public static void main(String[] args) {

        // Set up some data for comparison
        String[] firstString = {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        String[] copyOfFirstString = {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        String[] firstStringUnsorted = {"jkl","mno","pqr","stu","vwx","yz","abc","def","ghi"};
        String[] partialFirstString = {"abc","def","ghi","jkl","mno"};
        String firstStringReference[] = firstString;

        // Create pass-thru Lists from arrays to test List equality
        List firstList = Arrays.asList(firstString);
        List secondList = Arrays.asList(copyOfFirstString);

        // First, compare arrays using object.equals
        System.out.println("-----objects.equals------");
        System.out.println("firstString.equals(copyOfFirstString)" +firstString.equals(copyOfFirstString));
        System.out.println("firstString.equals(firstStringReference)" +firstString.equals(firstStringReference));
        // Compare arrays using Arrays.equals
        System.out.println("-----Arrays.equals------");
        System.out.println("Arrays.equals(firstString,copyOfFirstString)" +Arrays.equals(firstString,copyOfFirstString));
        System.out.println("Arrays.equals(firstString,firstStringReference" +Arrays.equals(firstString,firstStringReference));
        // Compare arrays using Arrays.compare
        System.out.println("-----Arrays.compare------");
        System.out.println("Arrays.compare(firstString,copyOfFirstString)"+ Arrays.compare(firstString,copyOfFirstString));
        System.out.println("Arrays.compare(firstString,firstStringReference)"+ Arrays.compare(firstString,firstStringReference));
        System.out.println(Arrays.compare(firstString,firstStringUnsorted));
        System.out.println(Arrays.compare(firstStringUnsorted,firstString));
        System.out.println(Arrays.compare(firstString,partialFirstString));
        System.out.println(Arrays.compare(partialFirstString,firstString));

        // If we compare the first elements, we get the same result as comparing the full arrays....
        System.out.println("firstString[0].compareTo(firstStringUnsorted[0]"
                + firstString[0].compareTo(firstStringUnsorted[0]));

        // New String array, only first 3 elements are shared with firstString - the prefix
        String[] notFullyPrefixedString = {"abc","def","ghi","yz","vwx","stu"};
        System.out.println("Arrays.compare(firstString,notFullyPrefixedString)"
                + Arrays.compare(firstString,notFullyPrefixedString));

        System.out.println();
//        System.out.println((int)'y' - (int)'j');

        // Verify that above result is same as comparing elements at first non-matching index...
        System.out.println("firstString[3].compareTo(notFullyPrefixedString[3])"
                + firstString[3].compareTo(notFullyPrefixedString[3]));

        // Comparing subsets of elements in Arrays
        System.out.println("\n------Arrays.compare for Element Ranges -------");
        // Set up arrays - note that both arrays contain "abc","def","ghi"
        String[] stringArray = {"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        String[] stringUnsortedArray = {"jkl","mno","pqr","stu","vwx","yz","abc","def","ghi"};

        // We are going to compare the 1st 3 elements of the ordered array, with the last 3 elements
        // of unordered array.
        System.out.println(Arrays.compare(stringArray,0,3,stringUnsortedArray,6,9));
        System.out.println(Arrays.compare(stringArray,0,5,stringUnsortedArray,6,9));
        System.out.println("\n--------List.equals-------");
        System.out.println("firstList.equals(secondList)" + firstList.equals(secondList));

        System.out.println("abc".compareTo("df"));

    }
}
