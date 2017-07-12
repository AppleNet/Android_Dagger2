package com.llc.dagger.login.component;

import com.llc.dagger.login.moudle.LoginMoudle;
import com.llc.dagger.login.presenter.impl.LoginPresenter;
import com.llc.dagger.register.presenter.impl.RegisterPresenter;

import dagger.Component;

/**
 * LoginPresenterComponent
 *
 * @author liulongchao
 * @since 2017/7/4
 */

@Component(modules = {LoginMoudle.class})
public interface LoginPresenterComponent {

    void injectModel(LoginPresenter loginPresenter);

    // MembersInjector修饰的时候 方法不能有参数 否则将抛出异常Error:(24, 41) 错误: Members injection methods may only return the injected type or void.
    //MembersInjector<IRegisterPresenter> injectRegisterModel();

    void injectRegisterModel(RegisterPresenter registerPresenter);
}
