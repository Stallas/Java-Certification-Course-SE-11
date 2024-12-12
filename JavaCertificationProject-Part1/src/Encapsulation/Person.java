package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic:  Applying Encapsulation principles to a class
    Sub-Topic:8. Java Bean applying encapsulation to a class
*/
public class Person {
    // We declare some private attributes
    private String name;
    private StringBuilder address;
    private int age;

    // We have a constructor for easy creation of Person and population of its attributes
    public Person(String name, StringBuilder address, int age){
        this.name = name;
//        Once object created and appending to it, could alter the code for SB not in case of int, String
//        Hence, to resolve this issue creating a new instance of SB.
//        this.address = address;
        this.address = new StringBuilder(address);
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StringBuilder getAddress() {
        return address;
    }

    public void setAddress(StringBuilder address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // Customise toString method
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }
}
