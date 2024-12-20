package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic: 1. Applying access modifiers
 */
class PackageAClass{
    void testAccess(){
        SuperClass c = new SuperClass();
        System.out.println("A non-subclass class has access to all but private fields of another class" +
                "in same package are non-accessible");
        System.out.println("SuperClass().publicInt : "+c.publicInt);
        System.out.println("SuperClass().packageInt : "+c.packageInt);
        System.out.println("SuperClass().protectedInt : "+c.protectedInt);
//       System.out.println("SuperClass().privateInt : "+c.privateInt);
    }
}
public class SuperClass {
    public int publicInt = 10;
    int packageInt = 20;
    protected int protectedInt = 30;
    private int privateInt = 40;
    public static void main(String[] args) {
        new SuperClass().testAccess();
        new PackageAClass().testAccess();
    }

    void testAccess() {
        System.out.println(this.getClass().getName() + " has access to all of its own attributes :");
        System.out.println("this.publicInt : "+this.publicInt);
        System.out.println("this.packageInt : "+this.packageInt);
        System.out.println("this.protectedInt : "+this.protectedInt);
        System.out.println("this.privateInt : "+this.privateInt);
    }
}
