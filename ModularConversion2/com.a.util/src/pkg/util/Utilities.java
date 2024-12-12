package pkg.util;
import pkg.utilility.staticStuff;
public class Utilities {
    public static void doUniversalStuff(){
        System.out.println("module com.a.util: pkg.util.Utilities does something");

        // create cyclic dependencies
        staticStuff.doStaticStuff("pkg.util.Utilities does something");
    }

    public static void doUniversalStuff(String s) {
        System.out.println("module com.a.util: " + s);

    }  }
