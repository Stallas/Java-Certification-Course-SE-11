
// Using TYPE_USE Annotation for a type
@TypeUseAnnotation
class ParentOfClass{

    // Using TYPE_USE Annotation for a constructor
    @TypeUseAnnotation ParentOfClass(){

    }
}
interface ContainingInterface<@TypeUseAnnotation T>{

    public T doThat();

    // Using TYPE_USE Annotation for a method parameter
    public default <S> S doThis(@TypeUseAnnotation S s){
        return s;
    }
}
// Using TYPE_USE at the TYPE level
@TypeUseAnnotation
// USING TYPE_USE Annotation in extends and implements clauses
public class TypeUseAnnotationsExample extends @TypeUseAnnotation ParentOfClass
        implements @TypeUseAnnotation ContainingInterface<ParentOfClass>{

    // Using TYPE_USE to annotate type for a field
    private @TypeUseAnnotation String privateAttribute;

    public static void main(String[] args) {

        // Using TYPE_USE when creating a variable using a type argument.
        ContainingInterface<@TypeUseAnnotation String> c;

        try {
            System.out.println("Testing type Use");
        }
        // Using TYPE_USE to annotation in a catch clause
        catch (@TypeUseAnnotation Exception e){
            // Using TYPE_USE annotation in a throws clause
            throw new @TypeUseAnnotation RuntimeException("whoops");
        }
    }

    // Using TYPE_USE for a method return type
    public @TypeUseAnnotation TypeUseAnnotationsExample doThat(){
        return this;
    }

}
