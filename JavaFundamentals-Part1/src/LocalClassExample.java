/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Local Classes
*/

public class LocalClassExample {

    private String defaultName = "Jane";
    private String lastName = "Doe";

    // Creating a non-static method that declares a local class
    private void methodWithLocalClass() {

        String defaultName = "Ralph";
// Changing local variable defaultname  is no effectively final ,Compiler won't let you reference
// it in the local class as we're attempting to do. compiler error in constructor.
//        if(this.defaultName != null){
//            defaultName = this.defaultName;
//        }
        // LocalClass Only has scope within this method
        class LocalClass {
            // local class can have all the same members as an outer class
            // (with the exception of static members).
            private String name;

            // Constructor on local class
            private LocalClass(String name) {
                if (name == null) {
                    this.name = defaultName;
                } else {
                    this.name = name;
                }
                this.name += " " + LocalClassExample.this.lastName; // local class can have access
                // to attributes of the enclosing class including private ones. or just lastName.
            }

            private void performSomeAction() {
                System.out.println("LocalClass.name = " + name);

            }

            // Local class cannot have static members
//            static class nestedClass{}
//            static final void main(String[] args){}
//            static Object myStaticObject;
//            enum Values{
//                One, Two
//            }
//            interface doAble{
//                doIt();
//            }
        }

        // Create multiple instances of local class within
        // the enclosing code's scope..
        LocalClass jeff = new LocalClass("Jeff");
        LocalClass martha = new LocalClass("Martha");
        LocalClass bob = new LocalClass("Bob");

        // Execute methods on instances of the local class
        jeff.performSomeAction();
        martha.performSomeAction();
        bob.performSomeAction();

        // Access fields directly from instance of local class
        System.out.println("Bob's name is: " + bob.name);

        new LocalClass(null).performSomeAction();
    }

    public static void main(String[] args) {
        new LocalClassExample().methodWithLocalClass();
    }
}