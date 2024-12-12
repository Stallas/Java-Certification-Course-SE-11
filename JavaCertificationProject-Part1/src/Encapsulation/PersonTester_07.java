package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic:  Applying Encapsulation principles to a class
    Sub-Topic:9. Java Bean applying encapsulation to a class
*/
public class PersonTester_07 {
    public static void main(String[] args) {
        // Create some local variables
        StringBuilder address = new StringBuilder("2234 Maple Ave, Ralphtown,PA,19000");
        int age = 45;
        String name = "Ralph";

        // Create instance of person with local variable references
        Person p = new Person(name,address,age);

        // change the local variable's data
        address.append("-0005");
        name = "Ralph's Wife";
        age = 40;

        // Create another instance of person with local variable references
        Person p2 = new Person(name,address,age);
        System.out.println(p);
        System.out.println(p2);
    }
}
