package com.llc.dagger.password.model;

import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.component.PwdComponent;
import com.llc.dagger.password.moudle.MySet;

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
     *  可以依赖注入Provider<Set<Password>>或Lazy<Set<Password>>,但是不能依赖Se<Provider<Password>>
     *  特别注意 需要指定注入哪个集合中，不然就会随机注入
     *  一个集合注入另一个集合的时候 就会产生将provide提供的所有数据注入进入
     * */
    @Inject
    @MySet("single")
    Set<Password> passwords;

    @Inject
    @MySet("double")
    Set<Password> passwordSet;


    public Password getPwd(PwdComponent build){
        passwords = build.passwords();
        return (Password) build.passwords().toArray()[0];
    }

    public Set<Password> getPwds(PwdComponent build){
        passwordSet = build.passwordSet();
        return passwordSet;
    }

}
