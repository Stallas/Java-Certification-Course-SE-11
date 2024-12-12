package annotations;

import java.lang.annotation.Repeatable;

// Repeatable Annotation Type requires containing annotation
@Repeatable(MyRepeatableAnnotations.class)
public @interface MyRepeatableAnnotation {
    int value() default 0;
}
