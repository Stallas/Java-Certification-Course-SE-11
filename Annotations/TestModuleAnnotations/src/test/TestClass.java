// We get a compiler error as packageannotation has to be defined in a package-info.file

//@PackageAnnotation
package test;

import annotations.PackageAnnotation;

public class TestClass {
    public static void main(String[] args) {
        new TestClass().doSomething();
    }
    public void doSomething(){
        System.out.println("Do Something");
    }
}
