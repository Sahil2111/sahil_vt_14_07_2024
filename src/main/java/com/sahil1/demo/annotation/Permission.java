package com.sahil1.demo.annotation;

import com.sahil1.demo.enums.LogicEnum;
import com.sahil1.demo.enums.PermissionsEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
    PermissionsEnum[] permissions();
    LogicEnum type();
}
