package Scope_;

public class NestedScope {
    public static void main(String[] args) {
        // local variable i declared and initialized
         int i=10;

        class locallyDefinedClass{// inner class
            {
                // i from method scope still visible in nested local class

            System.out.println("value of i BEFORE LOOP " + i);
            System.out.println("---------------");

            //Because this for loop is within a local class, this is valid
                for (int i=0;i<5;i++){ // i within scope
                    System.out.println("value of i during FIRST LOOP " + i);
                }
                System.out.println("---------------");
                // if we use for(i = 5 then same error inner class variable to be made final
                for (int i=5;i>0;i--){
                    System.out.println("value of i during SECOND LOOP " + i);
                }
                System.out.println("---------------");
                for (int j=i;j<15;j++){
                    System.out.println("value of i during THIRD LOOP " + i + ","+j);
                }
                System.out.println("Value of i AFTER LOOP "+i);
            }
        }
        System.out.println("value of i before local class instantiated "+i);
        new locallyDefinedClass();
       // i++; //variable accessed from within inner class needs to be final or effectively final
        System.out.println("value of i after local class instantiated "+i);
    }
}
