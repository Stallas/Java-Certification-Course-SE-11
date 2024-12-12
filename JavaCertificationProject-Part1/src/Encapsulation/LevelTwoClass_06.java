package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic:  Access Modifiers
    Sub-Topic:5. Constructors
 */
class LevelOneClass{
    // protected access constructor
    protected LevelOneClass(){
        System.out.println("protected LevelOneClass no args constructor");
    }
    // package-private i.e. default access constructor
    LevelOneClass(String text){
        System.out.println("package level LevelOneClass single params constructor");
    }
}
public class LevelTwoClass_06 extends LevelOneClass {
        // protected access constructor, deleting this protected creates compiler error on super() of Level3Class
        protected LevelTwoClass_06(){ // protected or public parent constructor called when extended.
            System.out.println("protected LevelTwoClass no args constructor");
        }
        // package-private i.e. default access constructor
        LevelTwoClass_06(String text){
            System.out.println("package level LevelTwoClass single params constructor");
        }
    }

