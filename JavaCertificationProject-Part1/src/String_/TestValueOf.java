package String_;
/*
    Topic: Create and Manipulate Strings
    Sub-Topic: 11. Out of Ordinary
 */
public class TestValueOf {
    public static void main(String[] args) {

        String george = "FredGeorgeSmith";

        //Constructor used to get substring beginning offset index 4 inclusive and 6 characters long
        String shortGeorge1 = new String(george.toCharArray(),4,6);
        String shortGeorge2 = String.valueOf(george.toCharArray(),4,6);
        String shortGeorge3 = george.substring(4,6);
        String shortGeorge4 = george.substring(4,10);//exclusive

        System.out.println("shortGorge1 = "+shortGeorge1);
        System.out.println("shortGorge2 = "+shortGeorge2);
        System.out.println("shortGorge3 = "+shortGeorge3);
        System.out.println("shortGorge4 = "+shortGeorge4);
        // Note that none of the methods change the variable george itself
        System.out.println("george = "+george);
    }
}
