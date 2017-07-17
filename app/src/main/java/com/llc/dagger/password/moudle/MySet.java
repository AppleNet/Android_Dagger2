package com.llc.dagger.password.moudle;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * com.llc.dagger.password.moudle.MySet
 *
 * @author liulongchao
 * @since 2017/7/14
 */
@Qualifier
@Retention(RUNTIME)
@Documented
public @interface MySet {

    String value() default "";
}
