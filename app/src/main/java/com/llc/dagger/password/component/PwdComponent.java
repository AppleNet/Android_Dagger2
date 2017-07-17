package com.llc.dagger.password.component;

import com.llc.dagger.password.PasswordActivity;
import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.moudle.PwdMoudle;

import java.util.Set;

import dagger.Component;

/**
 * com.llc.dagger.password.component.PwdComponent
 *
 * @author liulongchao
 * @since 2017/7/14
 */

@Component(modules = PwdMoudle.class)
public interface PwdComponent {

    void injectPasswordActivity(PasswordActivity passwordActivity);
    Set<Password> passwords();
}
