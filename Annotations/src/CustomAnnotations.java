import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedClassAnnotation{

}
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedInterfaceAnnotation{

}

// Intended as meta-annotation
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationAnnotation{

}
// Intended for Attribute
@Retention(RetentionPolicy.RUNTIME)
@interface AttributeAnnotation{

}
// Intended for Constructor
@Retention(RetentionPolicy.RUNTIME)
@interface ConstructorAnnotation{

}
// Intended for Local-variable
@Retention(RetentionPolicy.RUNTIME)
@interface LocalVariableAnnotation{

}
// Intended for Method
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation{

}
// Intended for Method Parameter
@Retention(RetentionPolicy.RUNTIME)
@interface MethodParameterAnnotation{

}
// Intended for Type (Class, Enum, Interface)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeAnnotation{

}
// Intended for Type Parameter
@Target(ElementType.TYPE_PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeParameterAnnotation{

}
// Intended for Type Use
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeUseAnnotation{

}

// Not required.
//public @interface CustomAnnotations {
//}
