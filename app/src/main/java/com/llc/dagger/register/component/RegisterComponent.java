package com.llc.dagger.register.component;

import com.llc.dagger.register.bean.RegisterBean;
import com.llc.dagger.register.moudle.MyEnum;
import com.llc.dagger.register.moudle.RegisterMoudle;

import java.util.Map;

import dagger.Component;

/**
 * com.llc.dagger.register.component.RegisterComponent
 *
 * @author liulongchao
 * @since 2017/7/17
 */

@Component(modules = RegisterMoudle.class)
public interface RegisterComponent {

    //void inject(RegisterActivity registerActivity);

    Map<String, RegisterBean> registerByString();

    Map<Integer, RegisterBean> registerByInt();

    Map<Long, RegisterBean> registerByLong();

    Map<Class<?>, RegisterBean> registerByClass();

    Map<MyEnum, RegisterBean> registerByEnum();

    //Map<ComplexKey,RegisterBean> registerBycomplex();
}
