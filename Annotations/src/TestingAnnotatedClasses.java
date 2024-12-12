/*
Section - Annotations

In the output folder:
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java
 */

import annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Apply annotations to the class
//@MyClassAnnotation()
//@MySourceAnnotation()
//@MyRuntimeAnnotation()
@MyRuntimeAnnotation(
        author = "Sri",
        version = 1.0,
        description = "This class is used for testing annotations"
)
// --Marker Annotation , Repeatable has default value 0
@MyRepeatableAnnotation

// --Single Element Annotation, Repeatable
// Do not have to specify element name if it is 'value'
@MyRepeatableAnnotation(10)
public class TestingAnnotatedClasses extends ParentClass implements SomeInterface{

    // Since we have defined target as field , we get compiler at class level annotation. Hence, redefine it.
    @MyClassAnnotation
    String myField = "Annotated Field";

    // reflection methods used to get information about class, methods, fields
    @MySourceAnnotation
    public void printRuntimeAnnotations(){
        Class c = this.getClass();

        showAnnotations(c);
        for(Method method : c.getDeclaredMethods()){
            showAnnotations(method);
        }
        for(Field field : c.getDeclaredFields()){
            showAnnotations(field);
        }
    }

    // Gets declared annotations, not inherited ones
    public void showAnnotations(Object e){
        Annotation[] annotations = null;
        if( e instanceof Class) annotations =   ((Class) e).getAnnotations();
//                ((Class) e).getDeclaredAnnotations();
        else if (e instanceof Method)  annotations =   ((Method) e).getAnnotations();
//                ((Method) e).getDeclaredAnnotations();
        else if (e instanceof Field) annotations = ((Field) e).getDeclaredAnnotations();

        for(Annotation annotation : annotations){
            System.out.println(e.getClass().getSimpleName() + " Annotation: "+annotation);
        }
    }

    public static void main(String[] args) {
        new TestingAnnotatedClasses().printRuntimeAnnotations();
    }
    // Implementing abstract method of ParentClass
    @Override
    public void abstractMethod() {
        System.out.println("Implemented abstractMethod");
    }

    // Implementing interface's method
    @Override
    public void interfaceMethod() {
        System.out.println("Implemented interfaceMethod");
    }
}
@MyFirstInheritedAnnotation
abstract class ParentClass{
    @MyFirstInheritedAnnotation
    public abstract void abstractMethod();
}

@MySecondInheritedAnnotation
interface SomeInterface{

    @MySecondInheritedAnnotation
    void interfaceMethod();
}
