package EncapsulationPartB;

import Encapsulation.ClassA;

public class ClassATest extends ClassA {
    private String text;
    // Here is an implied call to super() but code fails because of
    //no args constructor of the super class has no modifier, which means it is package by default.
    // there is no access to it as ClassATest is in another package
    // so changing to protected or public will work and print hello
    ClassATest(String text){
        setText(text);
    }
    public void setText(String text){
        this.text = text;
    }
    public static void main(String[] args) {
       System.out.println(new ClassATest("text"));

    }
}
