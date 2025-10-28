package com.gmail.ahmedded;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodInfo {
    String name();
    String returnType();
    String description();
}

