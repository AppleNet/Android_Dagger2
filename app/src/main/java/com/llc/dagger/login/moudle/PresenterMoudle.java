package com.llc.dagger.login.moudle;

import com.llc.dagger.login.presenter.ILoginPresenter;
import com.llc.dagger.login.presenter.impl.LoginPresenter;
import com.llc.dagger.login.view.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * PresenterMoudle
 *
 * @author liulongchao
 * @since 2017/7/4
 */
@Module
public class PresenterMoudle {

    LoginView loginView;
    public PresenterMoudle(LoginView loginView){
        this.loginView = loginView;
    }

    @Provides
    ILoginPresenter providePresenter() {
        return new LoginPresenter(loginView);
    }

}
