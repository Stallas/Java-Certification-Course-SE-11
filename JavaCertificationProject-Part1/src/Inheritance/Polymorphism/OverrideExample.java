package Inheritance.Polymorphism;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 10. Enable Polymorphism by overriding methods.
 */
class BaseClass{
    public void goodMethod(){
        System.out.println("Base class executing good method");
    }
    public void printInformation(CharSequence s){
        System.out.println("Base class prints "+s);
    }
    public CharSequence getInformation(){
        return getClass().getName();
    }
}
class ExtendedClass extends BaseClass{
    public void goodMethod(){
        super.goodMethod();
        System.out.println("And extended class executing a better method");
    }
    /*
    These are not overidden method, as parameter type is String , they are overloaded and run the code.
    public void printInformation(String s){
        System.out.println("Extended class prints "+s);
    }
    public String getInformation(){
        return getClass().getName();
    }
     */
    // Also, changing to private results in weaker access privilege
    public void printInformation(CharSequence s){
        System.out.println("Extended class prints "+s);
    }
    public CharSequence getInformation(){
        return getClass().getName();
    }
}
public class OverrideExample {
    public static void main(String[] args) {
        ExtendedClass e = new ExtendedClass();
        e.goodMethod();
        e.printInformation(e.getInformation());
        e.printInformation((CharSequence) e.getInformation());

    }
}
