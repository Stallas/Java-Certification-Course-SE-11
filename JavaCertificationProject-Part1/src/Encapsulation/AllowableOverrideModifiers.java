package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic: 4. Applying Access Modifiers to Methods
 */
// Employee class has a method for each type of modifier...
class Employee {
    public void printPublic() {
        System.out.println("An Employee can make a public statement");
    }

    protected void printProtected() {
        System.out.println("An Employee can make a protected statement");
    }

    void printPackage() {
        System.out.println("An Employee can make a package statement");
    }

    private void printPrivate() {
        System.out.println("An Employee can make a private statement" +
                " but only the employee can make it accessible through other means...");
    }

    // blog method is pass through to the private printPrivate method
    protected void blog(){
        printPrivate();
    }
}
// subclass of Employee overrides some of boss's methods, changing access modifiers
class Boss extends Employee{
    // making a private method on parent class to public on child class
    public void printPrivate() {
        System.out.println("A Boss's private statements can be made public now");
    }
    // making a package-private method on parent class to protected on child
    protected void printPackage(){
        System.out.println("A Boss's packaged speech can be shared with his children as well now");
    }
/* Assigning weaker access privilege leads to compile error.
    private void printPublic() {
        System.out.println("A Boss's public speech cannot be made private");
    }

     void printProtected() {
        System.out.println("A Boss's protected speech cannot be made packaged/default");
    }
   */
}
public class AllowableOverrideModifiers {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.printPublic();
        e.printPackage();
        e.printProtected();
//        e.printPrivate();
        // Employee use's blog method to provide controlled access to its printPrivate method
        e.blog();

        Boss b = new Boss();
        b.printPackage();
        b.printPrivate();
        b.blog();

    }
}
