package com.llc.dagger.login.component;

import com.llc.dagger.login.MainActivity;
import com.llc.dagger.login.moudle.LoginMoudle;

import dagger.Subcomponent;

/**
 * com.llc.dagger.login.component.MainActivitySubComponent
 *
 * @author liulongchao
 * @since 2017/7/12
 */


@Subcomponent(modules = LoginMoudle.class)
public interface MainActivitySubComponent {

    void injectMainActivity(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder{
        // SubComponent 必须显式地声明 Subcomponent.Builder，parent Component 需要用 Builder 来创建 SubComponent
        MainActivitySubComponent build();
    }
}
