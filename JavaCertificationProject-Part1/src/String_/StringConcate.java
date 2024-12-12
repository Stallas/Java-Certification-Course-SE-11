package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic:4. Concatenation Operator
 */
public class StringConcate {
    public static void main(String[] args) {
        String helloString = "hello";
        String worldString = "world";

        String firstString = helloString + " " + worldString;
        System.out.println("firstString = "+firstString);

        Object nullObj = null;
        String secondString = nullObj + " " + helloString;
        System.out.println("secondString = "+secondString);

        int i = 10;
        String thirdString = i + " " + helloString;
        System.out.println("thirdString = "+thirdString);

        // concatenating to Object not null
        Object ourObj = new ourSimpleClass();
        String fourthString = helloString + " " + ourObj;
        System.out.println("fourthString = "+fourthString);

        int j = 10;
        String resultString = i + j + " = " + i + j;
        System.out.println("resultString = "+resultString);

        String resultString2 = i + j + " = " + (i + j);
        System.out.println("resultString2 = "+resultString2);

        String resultString3 = ""+ i + j + " = " + i + j;
        System.out.println("resultString3 = "+resultString3);

    }
}

class ourSimpleClass{
    public String toString(){
        return "Our Simple Class";
    }
}
