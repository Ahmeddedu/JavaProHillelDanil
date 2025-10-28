package com.gmail.ahmedded;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Author {
    String firstName();
    String lastName();
}

