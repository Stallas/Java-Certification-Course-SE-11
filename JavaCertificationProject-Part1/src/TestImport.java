// A single-type-import declaration
import garden.vegetable.*;
public class TestImport {
    public static void main(String[] args) {

        //String class in the java.lang package, simple class name ok
        //no import statement required
        String s = "We are testing ways to import classes";
        System.out.println(s);

        //We are using simple name because we specified location in the import statement
        VineVegetable.main(args);
        nursery.vegetable.VineVegetable.main(args);

    }
}

class VineVegetable {

    public static void main(String[] args) {
        System.out.println("Printing a local vegetable");
    }
}
