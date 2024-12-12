package EncapsulationPartB;

import Encapsulation.LevelTwoClass_06;

/*
    Section 8: Applying Encapsulation
    Topic:  Access Modifiers
    Sub-Topic:6. Constructors
 */
// Extending a class from different package
class LevelThreeClass extends LevelTwoClass_06{

    // package-private constructor
    LevelThreeClass(){
        this("good");
        System.out.println("package LevelThreeClass no args constructor");
    }

    // private constructor
    private LevelThreeClass(String text){
        super();
        System.out.println("private LevelThreeClass single params constructor");
    }
}
public class ConstructorClass_05 {
    public static void main(String[] args) {

        // The constructor test
        LevelThreeClass c = new LevelThreeClass();
    }
}
