package com.llc.dagger.password.model;

import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.component.PwdComponent;

import java.util.Set;

import javax.inject.Inject;

/**
 * com.llc.dagger.password.model.PwdModel
 *
 * @author liulongchao
 * @since 2017/7/14
 */


public class PwdModel {

    /**
     * 当使用Provider 或者 lazy 的时候
     * 可以依赖注入Provider<Set<Password>>或Lazy<Set<Password>>,但是不能依赖Se<Provider<Password>>
     *
     * */
    @Inject
    Set<Password> passwords;

    @Inject
    Set<Password> passwordSet;

    public Password getPwd(PwdComponent build){
        passwordSet = build.passwords();
        return (Password) passwordSet.toArray()[0];
    }

    public Set<Password> getPwds(PwdComponent build){
        passwords = build.passwords();
        return passwords;
    }

}
