package EncapsulationPartB;

class SuperClass{
    static void testMe(){
        System.out.println("SuperClass");
    }
}
public class Test extends SuperClass{
    protected static void testMe(){
        System.out.println("Test");
    }
    public static void main(String[] args) {
        testMe();
//        super.testMe();
// Compile error occurs on Line 1 because you cannot use the access modifier 'protected' (or 'private')
// on an outer class. A compile error occurs on Line 4 because you cannot use 'super' in a static method.
    }
}
