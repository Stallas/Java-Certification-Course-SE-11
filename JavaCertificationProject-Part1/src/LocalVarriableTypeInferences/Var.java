package LocalVarriableTypeInferences;

import java.util.ArrayList;
import java.util.Arrays;

//You can name your class Var but not lowercase var
public class Var {
    static float taxRate = 0.0f;
    public static void main(String[] args) {
        //yes, you can name your LVTI variable "var"

        var var = new ArrayList<String>(Arrays.asList("First","Second","Third"));

        //And, can name a method var...
        var(var);

        // quiz
        var result = 0;
        var taxRate = 0.05;
        var price = 100;
        var adjustedTax = price * taxRate;
       // result = price + adjustedTax; The code leads to compile error as result is inferred to int
       // since adding double to int results in double so var result = 0.0
        System.out.println(result);
        System.out.println(taxRate);
    }
    // You cannot have a method parameter of type var but can have a method named "var" and method
    // parameter named as "var"
    public static void var(ArrayList<String> var){
        var x = var;// use LVTI to set local variable to our method parameter named "var"

        for (var y : x){
            System.out.println("var y ="+y);
        }
    }
}
