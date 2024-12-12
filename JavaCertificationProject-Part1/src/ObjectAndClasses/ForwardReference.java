package ObjectAndClasses;
/*
      Section 6: Describing and Using Objects and classes.
      Topic : Declare and Instantiate Objects/
      Sub-Topic: 4. Initializers and Forward References
   */
class Thing{

    Thing(){
//        secondString = "b";
        secondString = "b" + secondString;
    }
    // Initializer cannot have a instance variable declared below the statement
    //  other than an initialization statement. --> Illegal forward compiler error.
    {
//        firstString = "a";
//        firstString = "a" + secondString; (or) firstString = secondString;simple init but fails.
         firstString = this.secondString;
    }
    // Static initializer cannot have a static variable declared below the statement
    // other than an initialization statement. --> Illegal forward compiler error.
    static{
//       System.out.println(thirdString);
        thirdString = "c";
    }
    // Two Instance variables
    String firstString;
    String secondString;
    // Static variable
    static String thirdString;
    public String toString(){
        return firstString +" "+ secondString +" "+ thirdString;
    }

}
public class ForwardReference {
    public static void main(String[] args) {
        Thing one = new Thing();
        System.out.println(one);
    }
}
