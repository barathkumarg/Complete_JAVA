package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // CLASS type and remains util the exection of code completly
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnoatation{

    int value() default 1 ;
}


@CustomAnnoatation()
class Annotator{

}

public class Annotation {
    public static void main(String[] args) {
        // to access the annotation value
        Annotator obj = new Annotator();
        Class classobj = obj.getClass();
        Annotation an = (Annotation) classobj.getAnnotation(CustomAnnoatation.class);

        CustomAnnoatation ca = (CustomAnnoatation) an;
        System.out.println( ca.value());
    }
}
