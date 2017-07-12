package com.llc.dagger.login.component;

import com.llc.dagger.login.moudle.LoginMoudle;
import com.llc.dagger.login.presenter.impl.LoginPresenter;

import dagger.Component;

/**
 * LoginPresenterComponent
 *
 * @author liulongchao
 * @since 2017/7/4
 */

@Component(modules = LoginMoudle.class)
public interface LoginPresenterComponent {
    void injectModel(LoginPresenter loginPresenter);
}
