package com.lx.javas.annotation;

import java.lang.annotation.*;

/**
 * 用于输出方法信息时间
 * Created by lx on 2015/9/20.
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timer {}