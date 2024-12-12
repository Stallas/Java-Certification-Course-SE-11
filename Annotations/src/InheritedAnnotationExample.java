
// Annotate an Interface with one that had meta-annotation @Inherited
@InheritedInterfaceAnnotation
interface SuperInterface{

}

// Annotate a Class with one that had meta-annotation @Inherited
@InheritedClassAnnotation
class SuperClass{

}
// Do not annotate this class, which extends SuperClass and implements SuperInterface
public class InheritedAnnotationExample extends SuperClass implements SuperInterface{
    public static void main(String[] args) {
        System.out.println("Testing meta-annotations");
    }
}
