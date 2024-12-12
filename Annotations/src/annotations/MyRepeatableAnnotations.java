package annotations;

// Containing Annotation Type has value which is array of annotation which will be repeated
public @interface MyRepeatableAnnotations {
    MyRepeatableAnnotation[] value();
}
