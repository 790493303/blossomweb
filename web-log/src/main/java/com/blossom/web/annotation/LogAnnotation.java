package com.blossom.web.annotation;


import java.lang.annotation.*;

/**
 * @deprecated : service注解
 * Created by Blossom on 2017/3/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    //说明
    String description() default "";
}
