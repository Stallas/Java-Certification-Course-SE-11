package LambdaExpressions;
/*
Section 10: Programming Abstractly TThrough Interfaces
Topic: Lambda Expressions
Sub-Topic: 1.Anonymous Class
Step 1: just main method . Step 2 : Add interface. Step 3: method printhello
 */
public class AnonymousClass {
    /*
    Anonymous Class based on interface.
     */
    interface Helloable{
        public void hello();
    }
    public static void main(String[] args) {
        AnonymousClass a = new AnonymousClass();

        // We declare a local inner class (named) in this method
        class LocalClass extends Object{
            public void hello(){
                System.out.println("Hello local class");
            }
        }
        /*
        We immediately execute a method on the local class.
        If this were the only line of code that used the local class,
        An Anonymous class would make more sense.
         */
        new LocalClass().hello(); // local class requires an instantiation
        /*
        We create an anonymous class as a statement, not a declaration.
        This one is of type Object (extends Object)
         */
        Object anomClass = new Object(){
            public String toString(){
                return "Hello Anonymous Class";
            }
        };

        // We immediately execute a method on anonymous class
        System.out.println(anomClass.toString());

        // S2:Add an anonymous class that implements the interface Helloable. It's a statement not declaration.
        Helloable anomInterfacedClass = new Helloable() {
            @Override
            public void hello() {
                System.out.println("Hello Anonymous Class implementing Interface");
            }
        };
        // Executing methods on Anonymous class
        anomInterfacedClass.hello();

        /* Step3:
        In this code below, we actually pass an anonymous class in the call
        to a method that accepts a Helloable type as a parameter.
         */
        a.printHello(
                // Anonymous class created on the fly
                new Helloable() {
                    @Override
                    public void hello() {
                        System.out.println("Hello Anonymous Class passed as a parameter");
                    }
                }
        );

     //Step 4: In the code below, we now replace the anonymous class parameter with a lamda expression.
        a.printHello(
                () -> {System.out.println("Hello Lambda Expressions as a parameter");}
        );

    }

    public void printHello(Helloable h){
        h.hello();
    }
}
