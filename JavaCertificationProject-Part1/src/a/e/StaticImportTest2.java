package a.e;

public class StaticImportTest2 {
    public static final String APP_NAME = "second";

    public static void log(String statement){
        System.out.println("second logging statement: "+statement);
    }

    public void printUniqueStatement(){
        System.out.println("Im at Second");
    }
}
