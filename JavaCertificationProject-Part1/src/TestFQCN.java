public class TestFQCN {
    public static void main(String[] args) {

        //Using a FQCN when using the String class in the java.lang package
       // java.lang.String s = "We are testing ways to import classes";
       // System.out.println(s);

        //String class in the java.lang package, simple class name ok
        String s = "We are testing ways to import classes";
        System.out.println(s);

        //Any class in any other packages must be qualified or imported
        garden.vegetable.VineVegetable.main(args);

    }
}
