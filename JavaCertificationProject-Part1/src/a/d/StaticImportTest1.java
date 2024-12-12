package a.d;

public class StaticImportTest1 {
    public static final String APP_NAME = "first";

    public static void log(String statement){
        System.out.println("first logging statement: "+statement);
    }

    public void printUniqueStatement(){
        System.out.println("Im at first");
    }
}
