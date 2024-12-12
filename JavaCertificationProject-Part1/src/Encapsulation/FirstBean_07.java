package Encapsulation;
/*
    Section 8: Applying Encapsulation
    Topic:  Encapsulation in Java
    Sub-Topic:7. Java Bean applying encapsulation to a class
 */
public class FirstBean_07 {
    private String name;
    private int age;
    private boolean first;
    private int myOwnVariable;

    public FirstBean_07(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
    //  field variable is different from getter/setter name
    public int getFieldAlias() {
        return myOwnVariable;
    }

    public void setFieldAlias(int fieldAlias) {
        this.myOwnVariable = fieldAlias;
    }

    public static void main(String[] args) {

    }
}
