package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:2. Create and implement interfaces
 */

// Create an interface whose behavior is expand
interface Expandable{
    void expand();// abstract method implictly
}
// Create an interface whose behavior is expand
interface Collapsible{
    void collapse();
}
// Create a class that implements Collapsible
class IceCooler implements Collapsible{
    @Override
    public void collapse() {
        System.out.println("Camping trip over, fold it up");
    }
}
class SuitCase implements Expandable{
    @Override
    public void expand() {
        System.out.println("New clothes bought on vacation. Expand");
    }
}
class Portfolio implements Expandable,Collapsible{
    @Override
    public void expand() {
        System.out.println("Bull market, portfolio gets bigger.");
    }
    @Override
    public void collapse() {
        System.out.println("Bear market, portfolio shrinks to nothing.");
    }
}
public class TestGrowth{
    public static void main(String[] args) {
        // Create some objects. It could be argued these objects do not have lot in common.
        IceCooler ic = new IceCooler();
        SuitCase sc = new SuitCase();
        Portfolio po = new Portfolio();

        // We can set up arrays using interface types...
        Expandable[] eList = {po,sc};
        Collapsible[] cList = {po,ic};

        // We'll loop through Expandable array using enhanced for loop
        System.out.println("... Test the Expandable objects....");
        for (Expandable e:eList) {
//           e.expand();
           TestExpand(e);
        }
        // We'll loop through Collapsible array using enhanced for loop
        System.out.println("\n... Test the Collapsible objects....");
        for (Collapsible c:cList) {
            TestCollapse(c);
//            c.collapse();
        }
        TestGrowth.TestExpand(po);
    }

    // Test method that defines a parameter as Expandable
    public static void TestExpand(Expandable e){
        System.out.println(e.getClass().getName());
        e.expand();
    }
    // Test method that defines a parameter as Collapsible
    public static void TestCollapse(Collapsible c){
        System.out.println(c.getClass().getName());
        c.collapse();
    }
}
