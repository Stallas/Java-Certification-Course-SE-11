package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:1. Create and implement interfaces
 */
interface InterfaceExample{

    // Define some variables
    // All fields in Interface are public static final, and therefore require initialization.
    // public static int counter;

    // no modifiers at all
    String interfaceName = "InterfaceExample";

    // Single modifier
    static String staticInterfaceName = "StaticInterfaceExample";
    public String publicInterfaceName = "PublicInterfaceExample";
    final String finalInterfaceName = "FinalInterfaceExample";

    // double modifiers
    public final String publicFinalInterfaceName = "PublicFinalInterfaceExample";
    static final String staticFinalInterfaceName = "StaticFinalInterfaceExample";
    public static String publicStaticInterfaceName = "PublicStaticFinalInterfaceExample";
    // triple modifiers
    public static final String publicStaticFinalInterfaceName = "PublicStaticFinalInterfaceExample";

    // These methods are private because we declare them private.
    private String privateMethod(){
        return "private";
    }

    private static String privateStaticMethod(){
        return "private static";
    }
    // These methods are public implictly
    default String defaultMethod(){
        // You can call a private method from a default method.
        return privateMethod() + " then default";
    }
    static String publicStaticMethod(){
        // You can call private static method from public static method
        return InterfaceExample.privateStaticMethod()+" then static";
    }

    // This is the public method that would, in theory, be the method
    // that you want all implementing classes to have in common.
    abstract void theImportantMethod();
}
public class InterfaceTest implements InterfaceExample{
    public static void main(String[] args) {

        // Regardless of how you define it, a variable on an interface is
        // public static final
        System.out.println("All fields on an interface are  public static final");
        System.out.println(InterfaceExample.interfaceName);
        System.out.println(InterfaceExample.staticInterfaceName);
        System.out.println(InterfaceExample.publicInterfaceName);
        System.out.println(InterfaceExample.finalInterfaceName);
        System.out.println(InterfaceExample.publicFinalInterfaceName);
        System.out.println(InterfaceExample.staticFinalInterfaceName);
        System.out.println(InterfaceExample.publicFinalInterfaceName);
        System.out.println(InterfaceExample.publicStaticFinalInterfaceName);

        System.out.println("\nExecuting concrete methods on interface");
        // public static method can be accessed from type
        System.out.println(InterfaceExample.publicStaticMethod());

        // default method can be accessed from object which implements type
        InterfaceTest it = new InterfaceTest();
        System.out.println(it.defaultMethod());

        System.out.println("\nExecuting methods using the interface type");
        InterfaceTest anotherIt = new InterfaceTest();
        it.testInterface(anotherIt);

        Object o = anotherIt;
        it.testInterface(o);
    }

    @Override
    public void theImportantMethod() {
        System.out.println("This is the important method that all objects " +
                "implementing InterfaceTest must override and implement");
    }

    // Method that accepts the interface as a parameter
    public void testInterface(InterfaceExample it){
        System.out.println("Executing testInterface with InterfaceExample");
        it.theImportantMethod();
    }
    // Method that accepts the interface as an Object
    public void testInterface(Object o){
        System.out.println("Executing testInterface with Object");
        // Using Instanceof with an interface
        if(o instanceof InterfaceExample){

            // Casting using an interface
            InterfaceExample it = (InterfaceExample) o;
            it.theImportantMethod();
        }
    }
}
