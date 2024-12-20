/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Inner Class
*/

package inner;

// Enclosing Class
public class EnclosingClass {

    // Add Constructor
    EnclosingClass(String name) {
        this.outerName = name;
    }

    // instance field on enclosing class
    public String outerName = "outer";

    // instance field of the type of the inner class. If you have to access inner
    // member class from Enclosing class object then we need a reference of inner member class...
    public InnerMemberClass innerMemberClass = new InnerMemberClass();

    // instance method on enclosing class
    public void doSomethingOnInstance() {
        System.out.print("doSomethingOnInstance invoked: ");
        // invoke nested class's method via class reference
        System.out.println(new InnerMemberClass().getInstanceName());
    }

    // Begin declaration of inner member class named InnerMemberClass
    public class InnerMemberClass {

        // instance field
        public String instanceName = "InnerMemberClass.instanceName";

        // instance method
        public String getInstanceName() {
            return "getInstanceName() = " + this.instanceName;
        }

        public String getOuterName() {
//            return outerName;
            // Local variable shadows inner class member which in turn
            // shadows outer class's member.  Here we access all 3
            String outerName = "local_outerName";
            return outerName + " : " +
                    this.outerName + " : " +
                    EnclosingClass.this.outerName;
        }

        // static field
//        public static String staticName1 = "staticName";
//        // static method
//        public static String getStaticName(){
//            return "getStaticName = "+staticName1;
//        }
////      Both , enum and interface are implictly static so we can't define them in inner member class.
//        public enum Colors {
//            RED, BLUE, YELLOW
//        }
//
//        public interface NestedInterface {
//
//        }

        // static field
        public static final String staticName = "staticName";

        public String outerName = "outer";

    }  // Ends declaration of the inner member class

}

// This class tests the EnclosingClass and it's inner member class
// using a disassociated class.
class TestEnclosingClass {

    public static void main(String[] args) {
        EnclosingClass e = new EnclosingClass("e's Instance");
        e.doSomethingOnInstance();

        // We can declare a local variable of the inner class
        EnclosingClass.InnerMemberClass i;

        // But instantiating this way does not work... have to create a reference of outer class.
//        i = new EnclosingClass().InnerMemberClass();
//        i = new e.InnerMemberClass();

        // You must use the instance new operator, much like a method.
        i = e.new InnerMemberClass();

        // Use local variable referencing the inner member class to
        // access method on the inner class
        System.out.println("Invoking i.getOuterName: " + i.getOuterName());

        // Create another instance of the Enclosing Class
        EnclosingClass f = new EnclosingClass("f's Instance");

        // Declare and Assign a variable to the inner member class of
        // new instance in a single statement
        EnclosingClass.InnerMemberClass j = f.new InnerMemberClass();
        System.out.println("Invoking j.getOuterName: " + j.getOuterName());

        e.innerMemberClass.instanceName = "Testing";
        System.out.println(e.innerMemberClass.getInstanceName());


    }
}