package com.lx.javas.annotation;

import java.lang.annotation.*;

/**
 * 向属性注入值
 * Created by lx on 2016/4/19.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inject {
    String value() default "";
}
