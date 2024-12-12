package Encapsulation;

public class ClassA {
    String text = "hello";
    // Here is an implied call to super() but code fails because of
    //no args constructor of the super class has no modifier, which means it is package by default.
    // there is no access to it as ClassATest is in another package
    // so changing to protected or public will work and print hello
//    ClassA(){}
    protected ClassA(){} // public ClassA(){}
    protected ClassA(String text){}
    protected void setText(String text){
        this.text = text;
    }
    public String toString(){
        return text;
    }

}
