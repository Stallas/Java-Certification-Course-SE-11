package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 5.Final Methods
 */
// Create an abstract class with abstract methods
abstract class WillHaveManySubTypes{
    public abstract void doXYourWay();
    public abstract void doYYourWay();
    public abstract String toString();
    // Here we create a final method in an abstract class.
    final void doZOnlyOneWay(){
        System.out.println("Z can only be done this way");
    }
}
public class FinalMethodExample_05 extends WillHaveManySubTypes{
    private boolean flag = false;
    public static void main(String[] args) {

        // We instantiate an object and test all the methods
        FinalMethodExample_05 e = new FinalMethodExample_05();
        e.doXYourWay();
        e.doYYourWay();
        e.doZOnlyOneWay();
        System.out.println(e); // comment the toString() method results in FinalMethodExample_05@4573892
    }
    // Override and implement the abstract class''s abstract methods
    @Override
    public void doXYourWay() {
        System.out.println("X impln method");
    }

    @Override
    public void doYYourWay() {
        System.out.println("Y impln method");
    }


//    public void doZOnlyOneWay() {
//        System.out.println("Z impln method");
//    }
    @Override
    public String toString() {
      //  return super.toString(); // results in compiler error as you cannot call Objects.toString()
        // method since its made abstract.
        return "Not implemented yet";
    }
}
