package com.llc.dagger.register.moudle;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import dagger.MapKey;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * com.llc.dagger.register.moudle.ComplexKey
 *
 * @author liulongchao
 * @since 2017/7/17
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
@MapKey(unwrapValue = false)
public @interface ComplexKey {
    String names();
    Class<?> implementingClass();
    int[] thresholds();
}
