//// a single-static-import declaration for static variable
//import static java.lang.Math.PI;
//// a single-static-import declaration for static method
//import static java.lang.Math.sqrt;

// a Static-import declaration for static variable
import static java.lang.Math.*;
public class TestImportStatic {
    public static void main(String[] args){
        int radius = 2;

        // we can use a static class variable on the Math class to get the value of PI
       // double circumference = 2 * Math.PI * radius;
        double circumference = 2 * PI * radius;
        System.out.println("circumference = "+ circumference);

        // we can use a static class method on the Math class to get the square root of a number
        double sqrt = sqrt(81);
        System.out.println("sqrt = "+ sqrt);

    }
}
