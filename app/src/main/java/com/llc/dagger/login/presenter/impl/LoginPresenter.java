package com.llc.dagger.login.presenter.impl;

import com.llc.dagger.login.component.DaggerLoginPresenterComponent;
import com.llc.dagger.login.model.LoginModel;
import com.llc.dagger.login.moudle.LoginMoudle;
import com.llc.dagger.login.presenter.ILoginPresenter;
import com.llc.dagger.login.view.LoginView;

import javax.inject.Inject;

/**
 * LoginPresenter
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public class LoginPresenter implements ILoginPresenter {

    @Inject //将loginModel注入到presenter
    LoginModel loginModel;
    private LoginView loginView;

    /*
    *  有人习惯性的在这里加上@Inject 但是这个不是必须的。
    *  1. 如果moudle中的provides没有提供实例，只是提供了参数需要的值，这个时候 需要@Inject注解 注入到构造方法上
    *
    * */

    @Inject
    public LoginPresenter(){

    }

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        DaggerLoginPresenterComponent.builder().loginMoudle(new LoginMoudle()).build().injectModel(this);
    }



    @Override
    public void login(String userName, String pwd) {
        loginView.showLoaingProgress();
        loginModel.doLogin(userName, pwd);
        loginView.dismissLoaingProgess();
        loginView.onLogingSuccess();
    }
}
