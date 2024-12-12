package LocalVarriableTypeInferences;

public class VarDonts {
    //Invalid - static class variables cannot be declared with var
    //static var classVariable = 10;

    //Invalid - class instance variables cannot be declared with var
    // var instanceVariable = 20;
    public static void main(String[] args) {

    }
    // Invalid, cannot have a method return type of var
//    public static var returnThis(String[] args){
//        return args;
//    }
    // Invalid, cannot have method parameter of type var
//    public static String[] returnThat(var args){
//        return args;
//    }
}
