package com.llc.dagger.password.bean;

/**
 * com.llc.dagger.password.bean.Password
 *
 * @author liulongchao
 * @since 2017/7/14
 */


public class Password {

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

    public Password(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Password() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() == Password.class){
            Password password = (Password) obj;
            return id.equals(password.getId()) || pwd.equals(password.getPwd());
        }

        return false;
    }
}
