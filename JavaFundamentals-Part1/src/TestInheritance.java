/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Nested Class, Extras
*/

public class TestInheritance extends OuterMost {
    // Suppose a class extends OuterMost.PublicInner throws compiler error.
    public static void main(String[] args) {
        new TestInheritance().testInnerClassMembers();
//        new ProtectedInner();
//        A static method has no 'this'... they are shorthand for this.newConstruct
//        new PublicInner();
    }

    private void testInnerClassMembers() {
        // non-static method - instance of current class exists so inner
        // classes (with the right access modifiers) are available...
        new ProtectedInner();
        // First Level
        new PublicInner();

        this.new ProtectedInner();
        // First Level
        this.new PublicInner();

        // Second Level
        new PublicInner().new NestedInnerSecondLevel();
//        new PublicInner(). NestedInnerSecondLevel();

        // Customized Second Level
        new KeepExtending();
    }

    // This inner class extends the inner class that was inherited
    // from the OuterMost class or can have just extends PublicInner
    class KeepExtending extends OuterMost.PublicInner {
        KeepExtending() {
            System.out.println("Extend the inner class as an " +
                    "inherited member");
        }
//  or we can have simply extends NestedInnerSecondLevel
        class ExtendingFurther extends
                OuterMost.PublicInner.NestedInnerSecondLevel {
            ExtendingFurther() {
                System.out.println("Extending a deeper level of " +
                        "an inherited member");
            }
        }
    }
}