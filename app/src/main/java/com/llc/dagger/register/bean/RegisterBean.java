package com.llc.dagger.register.bean;

import javax.inject.Inject;

/**
 * com.llc.dagger.register.bean.RegisterBean
 *
 * @author liulongchao
 * @since 2017/7/17
 */


public class RegisterBean {

    private String id;
    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Inject
    public RegisterBean() {
        id = "24";
        pwd = "Kobe";
    }

    public RegisterBean(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
}
