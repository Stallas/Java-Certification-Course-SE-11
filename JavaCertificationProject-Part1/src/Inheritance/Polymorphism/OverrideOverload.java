package Inheritance.Polymorphism;
import java.util.Arrays;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 11. Enable Polymorphism by overriding methods.
 */
// MostBasicClass has 3 overloaded methods, all named baseMethod
class MostBasicClass{
    public void baseMethod(){
        System.out.println("- PARENT OVERLOAD 'void baseMethod()'");
    }
    public Object baseMethod(String a){
        System.out.println("- PARENT OVERLOAD 'Object baseMethod(String a)'");
        return a;
    }
    public int baseMethod(int... intArray) throws ArrayIndexOutOfBoundsException{
        System.out.println("- PARENT OVERLOAD 'int baseMethod(int... intArray)'");
        return intArray[intArray.length + 1];
    }
}
public class OverrideOverload extends MostBasicClass{
    // This method overrides one of MostBasicClass's overloaded methods
    public void baseMethod(){
        super.baseMethod();
        System.out.println("- CHILD OVERRIDES 'void baseMethod()'");
    }

    // Overloaded baseMethod in the child class..
    public Object baseMethod(String[] a){
        System.out.println("- CHILD OVERLOADED 'Object baseMethod(String[] a)'");
        return Arrays.toString(a);
    }

    //Override baseMethod in the child class..
    // Note that it is ok to define a return type which can be said to be an Object..
    public Integer baseMethod(String a){
        System.out.println("- CHILD OVERRIDE 'Object baseMethod(String a)'" +
                " with 'Integer baseMethod(String a)'");
        return Integer.valueOf(a);
    }
    public int baseMethod(int[] intArray){
        System.out.println("- CHILD OVERRIDE 'int baseMethod(int[] intArray)'");
        return intArray[intArray.length -1];
    }
    // Main method will call our Overridden,Overloaded methods
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5};

        OverrideOverload oo = new OverrideOverload();
        int i = 0;
        oo.baseMethod();
        oo.baseMethod("10");
        oo.baseMethod(new String[]{"10"});

        try{
            // We'll make the call with var args
            i = oo.baseMethod(intArray);
//            i = oo.baseMethod(1,2,3,4,5);
        }
        catch (Exception e){
            System.out.println("Uh oh, error occurred in call to "+oo.baseMethod(intArray));
        }
        System.out.println("local variable i = "+i);
    }
}
