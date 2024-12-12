import java.util.Arrays;
import java.util.ResourceBundle;

public class LocaleBundleTest {
    public static void main(String[] args) {

        // You'll note that you can invoke getBundle without passing a locale, the default locale will be used.
        ResourceBundle localeData = ResourceBundle.getBundle("SecondBundle");

        // Getting all values using getObject with key
        localeData.keySet().forEach((s)->
                System.out.println("\t" + s + " = "+
                        localeData.getObject(s))
                );

        // Getting an array of string from bundle
        String[] synonyms = localeData.getStringArray("synonyms");
        System.out.println(Arrays.toString(synonyms));

        // Getting an object from bundle and casting
        Employee jane = (Employee) localeData.getObject("jane");
        System.out.println(jane);

        // Getting a primitive from bundle and casting
        int age = (int) localeData.getObject("age");
        System.out.println("age is "+ age);

    }
}
