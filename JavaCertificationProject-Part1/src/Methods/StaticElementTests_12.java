package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 12. static keyword
 */
// This class demonstrates static fields, a static initializer, and a static method.
class StaticStuff{
    static final String appName = "A Good App";
    // static initializer
    static{
        System.out.println("Initializing StaticStuff class");
//        StaticStuff.counter++;
    }
    static void printAppName(){
        System.out.println("Application Name = "+appName + " ,counter = "+counter);
    }
    static int counter;
}
public class StaticElementTests_12 {
    public static void main(String[] args) {

        // System.out.println("Application Name = "+StaticStuff.appName);

        // Add some 'work' first to prove StaticStuff not initialised on start-up
        for(int i=0;i<3;i++){
            System.out.println("printing "+(i));
        }

        //** Create an object of type StaticStuff
        StaticStuff s = null;

        // We access static member of the StaticStuff class
        System.out.println("Application Name = "+s.appName);
        int myCounter = StaticStuff.counter;
        System.out.println("myCounter = "+myCounter);//s.counter its same when static obj is null then
        // Making a static field final and creating an object of type null and accessing appname wont initializes
        // the static block. important to note. Hence,invoking the static counter fields.
        // try removing the final field and test the output.


        // Execute static method on StaticStuff
        s.printAppName(); // execute this statement only

        // comment above code and execute this block
        StaticStuff s0 = new StaticStuff();
        System.out.println("Created first instance of StaticStuff");
        s0.printAppName();
        StaticStuff s1 = new StaticStuff();
        System.out.println("Created second instance of StaticStuff");
        s1.printAppName();
        StaticStuff s2 = new StaticStuff();
        System.out.println("Created third instance of StaticStuff");
        s2.printAppName();
    }
}
