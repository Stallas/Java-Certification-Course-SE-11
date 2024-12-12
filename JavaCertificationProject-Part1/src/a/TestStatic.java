package a;

import a.d.StaticImportTest1;
import static a.d.StaticImportTest1.*;
import a.e.StaticImportTest2;
//import static a.d.StaticImportTest2.*;
public class TestStatic {
    public static void main(String[] args){

        System.out.println("APP_NAME: "+APP_NAME);
        log("This is a static import statement");
        new StaticImportTest1().printUniqueStatement();

        System.out.println("APP_NAME: "+StaticImportTest2.APP_NAME);
        StaticImportTest2.log("This is a static import statement");
        new StaticImportTest2().printUniqueStatement();
    }
}
