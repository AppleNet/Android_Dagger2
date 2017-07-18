package com.llc.dagger.forget.moudle;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * com.llc.dagger.forget.moudle.ForgetScop
 *
 * @author liulongchao
 * @since 2017/7/18
 */

@Scope
@Retention(RUNTIME)
@Documented
public @interface ForgetScop {
}
