package com.llc.dagger.login.moudle;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * com.llc.dagger.login.moudle.Named
 *
 * @author liulongchao
 * @since 2017/7/12
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Named {
    String value() default "";
}
