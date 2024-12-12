package ObjectAndClasses;
/*
      Section 6: Describing and Using Objects and classes.
      Topic : Declare and Instantiate Objects/
      Sub-Topic: 6. Final Fields

      final static field initialised either during declaration or initialisation.
      final field i.e. regular field initialised either during declaration or initialisation or constructor.
      All final non-static field must be initialised at the constructor if it is not initalised during declaration.
      i.e.
   */
class Constants{
    /*
    Final static class variables are considered constants.
    There is one reference to them (static).
    they cannot be altered (final)
     */
    final static String ONE = "final static String ONE = one";
    final static String TWO = "final static String TWO = two";
    // Compiler error if static initializer removed
    final static String THREE ;
    static {
        THREE = "final static String THREE = three";
    }
}
public class FinalFields {
    // You cannot create final instance variables that are not static.
    final String FOUR;// initialise either during declaration,initialization or constructor.
    // initializer sets final field four
    {
        FOUR =  "final static String FOUR = four";
//        FIVE =  "final static String FIVE = fives";
    }
//    All final non-static field must be initialised at all the constructor
//    if it is not initialised during declaration.commenting FIVE in constructor leads to compile error.
    final String FIVE;

    // constructor sets final field five
    FinalFields(){
        FIVE =  "final Field FIVE = five";
    }
    // new constructor takes an argument
    FinalFields(String value){
        FIVE =  "final Field FIVE = " + value;
    }

    public static void main(String[] args) {
        // Access and print the constants.
        System.out.println(Constants.ONE);
        System.out.println(Constants.TWO);
        System.out.println(Constants.THREE);
        System.out.println((new FinalFields()));
        System.out.println("---------------------------");
        System.out.println((new FinalFields("six")));

    }
    public String toString(){
        return FOUR + "\n" + FIVE;
    }
}
