/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Default methods
// Class implements the interfaces
case1: default method override ... test using implements then extends class
baseclass is choosed over the interfaces.
case2: define abstract method ... so have to override but compiler error Bad qualifier type in default super call.
what we really want to invoke default method ? comes case3

// when we remove defaultNotAbstractMethod leads to compiler error so we extend DefaultClass which
actually extends base class that contains defaultNotAbstractMethod method no compiler error.
*/

// Interface extends Defaultable, and overrides the default method
public interface MoreSpecificDefaultable extends Defaultable {
     void defaultNotAbstractMethod();
/*
Execute this method with class MoreSpecific implements Defaultable, MoreSpecificDefaultable
and class MoreSpecific extends DefaultClass implements Defaultable, MoreSpecificDefaultable
     default void defaultNotAbstractMethod(){
         System.out.println("MoreSpecificDefaultable default method");
     }

 */
}

// Class implements both interfaces
class MoreSpecific extends DefaultClass implements
        Defaultable, MoreSpecificDefaultable {

    // implements the abstractMethod and calls the default method
    public void abstractMethod() {
        defaultNotAbstractMethod();  // Which default method is used?
    }

    // invokes the abstract method
    public static void main(String[] args) {
        new MoreSpecific().abstractMethod();
    }

/* Case2:
   @Override
    public void defaultNotAbstractMethod() {
        // Try to specify that you want to use Defaultable's default method
        Defaultable.super.defaultNotAbstractMethod();
    }
 */
    /* Case3:
    @Override
        public void defaultNotAbstractMethod() {
            new Defaultable(){
                @Override
                public void abstractMethod() {

                }
            }.defaultNotAbstractMethod();
        }

     */
}