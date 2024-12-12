import java.util.Arrays;

// Create a simple generic class with Type T and name as attribute
class MyClass<T>{
    T name;

    MyClass(T name){
        this.name = name;
    }
}
public class SafeVarargsExample {
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Generic Array creation is not allowed
//        MyClass<String>[] myArray = {
//                new MyClass<>("jane"),
//                new MyClass<>("joe")
//        };

        // Changing the type String to generic, compiles fine. We are making an array reified type i.e. raw
        // if we hover on this MyClass,  Raw use of parameterized class 'MyClass'
        // Other compiler warnings are hover on doSomething call and its method.
        MyClass[] myArray = {
                new MyClass<>("jane"),
                new MyClass<>("joe")
        };

        // Yet you can do this... Unchecked generics array creation for varargs parameter
        doSomething(new MyClass<>("jane"),new MyClass<>("joe"));
    }

    // Method with parameterized typed MyClass varargs
    // Possible heap pollution from parameterized vararg type still we do get on adding
    // @SuppressWarnings("varargs") but not @SuppressWarnings("unchecked")
//    @SuppressWarnings("unchecked")
    @SafeVarargs
    public static void doSomething(MyClass<String>... myStuff){
        Arrays.stream(myStuff).forEach(System.out::println);
    }
}
