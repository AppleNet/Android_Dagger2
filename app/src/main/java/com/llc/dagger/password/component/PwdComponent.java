package com.llc.dagger.password.component;

import com.llc.dagger.password.PasswordActivity;
import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.moudle.MySet;
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

    /**
     * 特别注意 需要指定注入哪个集合中，不然就会随机注入
     *
     * */
    @MySet("single")
    Set<Password> passwords();

    @MySet("double")
    Set<Password> passwordSet();
}
