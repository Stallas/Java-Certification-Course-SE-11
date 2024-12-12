package Arrays;

import java.util.Arrays;

/*
Section 5: Working with Java Arrays
Topic: 6. Two Dimensional Array
2D initializer,print using for loop & Arrays.toString for each row, Arrays.deepToString
shallow clone , deep clone, Arrays.copyOf , changing original array to check if it reflects in cloned/copied array
 */
public class TwoDimensionalArray {
    public static void printArray(String arrayName, int[][] inputArray){
        System.out.println("----------------------");
        System.out.println(arrayName + " Reference : " + inputArray);
        for(int row =0;row < inputArray.length;row++){
            printRow(arrayName, inputArray[row],row);
        }
    }

    public static void printRow(String arrayName, int[] inputArray, int row) {
        System.out.println(arrayName + " : "+ inputArray + " : Row " + (row + 1)+ " : "+
                Arrays.toString(inputArray));
    }
    public static void main(String[] args) {

        // Create a 2D array
        int[][] intArray = new int[2][10];

        // Let's see what this looks like using the method we created
        printArray("intArray",intArray);

        // We can also print the 2D array using Arrays.deepToString()
        System.out.println("Printing an array using Arrays.deepToString(intArray)"+
                Arrays.deepToString(intArray));

        // If we use an array initializer, formatting this way helps readability
        int[][] variableCols = {
                {1,2,3},
                {4,5,6,7},
                {0,3,4,6},
                {1}
        };
        printArray("variableCols",variableCols);

        // Clone a copy of your 2D array, but it is a shallow clone
        int[][] clonedArray = variableCols.clone();
        printArray("clonedArray",clonedArray);

        // Arrays.copyOf works here ,but need to cast back to 2D array
        int[][] copiedCopy = (int[][]) Arrays.copyOf(variableCols,variableCols.length);
        printArray("copiedCopy",copiedCopy);

        System.out.println("---------------------------");
        // Comparing our arrays, row 3...
        printRow("variableCols",variableCols[2],2);
        printRow("clonedArray",clonedArray[2],2);
        printRow("copiedCopy",copiedCopy[2],2);

        System.out.println("---------------------------");
        // We can take our shallow copy and make it 'deep' manually...
        // changes made in original array doesn't reflect in clonedarray when done deeep clone
        for(int i=0; i < clonedArray.length;i++){
            clonedArray[i] = clonedArray[i].clone(); // clone each element

        }
        // Change data on one of our original data points.
        variableCols[2][3] = 10000;
        printRow("variableCols",variableCols[2],2);
        printRow("clonedArray",clonedArray[2],2);
        printRow("copiedCopy",copiedCopy[2],2);
        System.out.println("---------------------------");

        //Quiz....... These are valid ways of Array initializer
        int[][] spreadsheet = new int[3][];// initialised both [3][3] then output --> 000 123 000
        spreadsheet[0] = new int[3];
        spreadsheet[1] = new int[]{1,2,3};
        System.out.println(Arrays.deepToString(spreadsheet));// [[0,0,0],[1,2,3],null]
    }
}
