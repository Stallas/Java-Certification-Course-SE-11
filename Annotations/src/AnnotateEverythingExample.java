// Annotating a class
@TypeAnnotation
public class AnnotateEverythingExample {

    // Annotating a field
    @AttributeAnnotation
    private String aField;

    // Annotating a constructor
    @ConstructorAnnotation
    AnnotateEverythingExample(){

    }

    // Annotating a method
    @MethodAnnotation
    // Annotating a method parameter
    void doSomething(@MethodParameterAnnotation String s){

        // Annotating a local variable
        @LocalVariableAnnotation
        var localVariable = 1;

        System.out.println(s);
    }

    // Annotating a type parameter - we get compiler error hence adding target to customAnnotaions
    <@TypeParameterAnnotation T> T getSomething(T t){
        return t;
    }

    // TypeUseAnnotation - we get compiler error hence adding target to customAnnotaions.
//  Both were introduced in Java 8 and whose target need to be specified.
    public static void main(String[] args) {

        // Annotating a use of a type (TYPE_USE) in a new object
        AnnotateEverythingExample e = new @TypeUseAnnotation AnnotateEverythingExample();
        Object o = e;

        // Annotating a use of a type (TYPE_USE) while casting
        AnnotateEverythingExample e2 = (@TypeUseAnnotation AnnotateEverythingExample) o;
        e.doSomething("Hello");
    }
}
