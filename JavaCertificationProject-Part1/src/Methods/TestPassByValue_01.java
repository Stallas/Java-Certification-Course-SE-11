package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
 */
public class TestPassByValue_01 {
    public static void main(String[] args) {

        // Set up some test data
        // Primitive data variables
        int a = 1;
        int b = 2;

        // String variables
        String aString = new String("123");
        String bString = new String("456");

        // Object variables using StringBuilder
        StringBuilder abc = new StringBuilder("abc");
        StringBuilder def = new StringBuilder("def");

        System.out.println("--------Before method call----------");

        // print out values and hashcodes prior to method call
        System.out.println("abc.hashCode() : "+abc.hashCode() +" value = "+ abc);
        System.out.println("def.hashCode() : "+def.hashCode() +" value = "+ def);
        System.out.println("aString.hashCode() : "+aString.hashCode() +" value = "+ aString);
        System.out.println("bString.hashCode() : "+bString.hashCode() +" value = "+ bString);
        System.out.println("a = "+a);
        System.out.println("b = "+b);

        // Execute method on each type of data
        changeValue(a,b);
        changeValue(aString,bString);
        changeValue(abc,def);

        System.out.println("--------After method call----------");

        // print out values and hashcodes after the method call
        System.out.println("abc.hashCode() : "+abc.hashCode() +" value = "+ abc);
        System.out.println("def.hashCode() : "+def.hashCode() +" value = "+ def);
        System.out.println("aString.hashCode() : "+aString.hashCode() +" value = "+ aString);
        System.out.println("bString.hashCode() : "+bString.hashCode() +" value = "+ bString);
        System.out.println("a = "+a);
        System.out.println("b = "+b);

    }

    public static void changeValue(Object o1,Object o2) {
        // This code changes the values of the parameters passed to it.
        String s = o1.getClass().getName();
        System.out.println(s);
        switch(o1.getClass().getName()){
            case ("java.lang.Integer"):
                o1 = 10;
                o2 = 20;
                break;
            case ("java.lang.String"):
                o1 = "aaaa";
                o2 = "bbbb";
                break;
            case ("java.lang.StringBuilder"):
                o1 = ((StringBuilder) o1).append("xyz");
                o2 = ((StringBuilder) o1).append("zzz");
                break;
        }
    }
}
