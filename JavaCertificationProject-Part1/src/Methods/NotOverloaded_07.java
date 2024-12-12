package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 7.Overloaded Methods
 */
class NoLoad{
    public void bestMethod(int i){
        System.out.println("bestMethod for int");
    }
    /*
    // Method with different access modifier
    private void bestMethod(int i){
        System.out.println("private bestMethod for int");
    }
    // Method with a different name for the parameter
    public void bestMethod(int myInteger){
        System.out.println("bestMethod for int");
    }
    // Method with a different non-access modifier
    public static void bestMethod(int i){
        System.out.println("static bestMethod for int");
    }
    // An abstract method in a non-abstract class
    public abstract void bestMethod(int i);

    // Method with a different return type
    public int bestMethod(int i){
        System.out.println("static bestMethod for int");
        return i;
    }
     */

}
public class NotOverloaded_07 {
    public static void main(String[] args) {
        NoLoad n = new NoLoad();
        n.bestMethod(1);
    }
}
