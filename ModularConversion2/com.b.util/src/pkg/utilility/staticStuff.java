package pkg.utilility;


import pkg.util.Utilities;

public class staticStuff {
//    public static void doStaticStuff(){
//        System.out.println("module com.b.util: pkg.util.StaticStuff does Something");
//    }

    public static void doStaticStuff() {
        System.out.println("module com.b.util: pkg.util.StaticStuff does Something");
        Utilities.doUniversalStuff("pkg.util.staticStuff does something");
    }

    public static void doStaticStuff(String s) {
        System.out.println("module com.b.util: " + s);
    }
}