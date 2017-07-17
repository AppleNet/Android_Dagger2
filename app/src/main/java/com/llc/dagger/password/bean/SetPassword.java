package com.llc.dagger.password.bean;

import java.util.Set;

import javax.inject.Inject;

/**
 * com.llc.dagger.password.bean.SetPassword
 *
 * @author liulongchao
 * @since 2017/7/17
 */


public class SetPassword {

    Set<Password> passwordSet;

    @Inject
    public SetPassword(){
    }

    @Override
    public String toString() {
        return "SetBananaBean{" +
                "set=" + passwordSet +
                '}';
    }

    public Set<Password> getPasswordSet() {
        return passwordSet;
    }

    public void setPasswordSet(Set<Password> passwordSet) {
        this.passwordSet = passwordSet;
    }
}
