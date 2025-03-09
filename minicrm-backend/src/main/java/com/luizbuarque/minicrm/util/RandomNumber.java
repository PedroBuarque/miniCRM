package com.luizbuarque.minicrm.util;

import org.hibernate.annotations.IdGeneratorType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IdGeneratorType(RandomNumberIdGenerator.class)  // Register your custom generator
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RandomNumber {
    // You can add attributes here if needed for configuration.
    // For now, leave it empty.
}