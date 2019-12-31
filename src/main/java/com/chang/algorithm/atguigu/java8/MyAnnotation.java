package com.chang.algorithm.atguigu.java8;

import java.lang.annotation.ElementType.*;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Repeatable(MyAnnotations.class)
@Target({TYPE,FIELD,METHOD, PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "mo ren";
}
