package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 11. Overloaded constructors
 */
// The Calculator class demonstrates overloading static methods. Each method prints a unique message so we can
// understand which method was picked by the JVM.
class Calculator{
    public static long add(int a, Double f){
        System.out.println("int + Double");
        long result = (long) (a + f);
        return result;
    }
    public static long add(int a, long... f){
        System.out.println("int + Var args long b");
       int total=a;
       for (long val:f){
           total += val;
       }
        return total;
    }
    public static long add(long... f){
        System.out.println(" Var args long f");
        int total=0;
        for (long val:f){
            total += val;
        }
        return total;
    }
    public static long add(int a, long f){
        System.out.println("int + long");
        return a + f;
    }
}
public class OverloadTests_11 {
    public static void main(String[] args) {
        // Testing Calculator with multiple primitive data types
        var result = Calculator.add(1,2);
        System.out.println("result = "+result);

        result = Calculator.add(1,2,4);
        System.out.println("result = "+result);

        result = Calculator.add(1,101);
        System.out.println("result = "+result);

        result = Calculator.add(1,12.3);
        System.out.println("result = "+result);
    }
}
