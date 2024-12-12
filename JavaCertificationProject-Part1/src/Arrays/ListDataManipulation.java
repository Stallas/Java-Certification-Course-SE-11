package Arrays;

import java.util.Arrays;
import java.util.List;

/*
Section 5: Working with Java Arrays
Topic:4.  Using list to manipulate data
Arrays --> List ,get,sort,replaceAll, List.of & List.copyOf
 */
public class ListDataManipulation {
    public static void main(String[] args) {

        // Set up some test data for use in our tests
        String[] primaryColors = {"red","blue","yellow"};
        String[] secondaryColors = {"green","orange","purple"};

        System.out.println("----Manipulating array data using a List backed by an array-----");

        // Arrays.asList returns a List backed by the array
        List<String> colorList = Arrays.asList(primaryColors);
        System.out.println("colorList : " + colorList.toString());

        // Use get method to gat an element in the array
        String firstColor = colorList.get(0);
        System.out.println("firstColor is " + firstColor);

        // Sort the array via the list reference
        colorList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("\ncolorList after sort : "+colorList.toString());
        System.out.println("Primary colors : "+ Arrays.toString(primaryColors));

        // Use replaceAll method to change all values in the array via List reference
        colorList.replaceAll(s -> s+"ish");
        System.out.println("\ncolorList after replacing all values : "+colorList.toString());

        // And what happens when we change the underlying array ?
        primaryColors[0] = "blueish";
        System.out.println("Primary colors after array changed : "+ Arrays.toString(primaryColors));

        System.out.println("-----List.of and List.copyOf Examples ---------");
        // List.of method can take an array and make it a list
        List secondColorList = List.of(primaryColors);
        List thirsColorList = List.copyOf(Arrays.asList(primaryColors));
        System.out.println("secondColorList : " + secondColorList.toString());
        System.out.println("thirsColorList :" + thirsColorList.toString());

        // change value on original array
        primaryColors[0] = "blue";
        System.out.println("Primarycolors after making first element change : "+ Arrays.toString(primaryColors));
        System.out.println("secondColorList after array changed: " + secondColorList.toString());
        System.out.println("thirsColorList after array changed:" + thirsColorList.toString());

        // secondColorList created from List.of method is immutable
        // so changing it leads to UnsupportedOperationException
        try{
            secondColorList.set(0,"cyan");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // thirdColorList created from List.of method is immutable
        try{
            thirsColorList.set(0,"cyan");
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
