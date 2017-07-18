package com.llc.dagger.forget.bean;

import javax.inject.Inject;

/**
 * com.llc.dagger.forget.bean.Forget
 *
 * @author liulongchao
 * @since 2017/7/18
 */

public class Forget {

    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Forget(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Inject
    public Forget() {
        this.name = "Kobe";
        this.pwd = "24";
    }
}
