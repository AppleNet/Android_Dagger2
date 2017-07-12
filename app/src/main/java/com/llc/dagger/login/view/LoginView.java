package com.llc.dagger.login.view;

import com.llc.dagger.base.view.BaseView;

/**
 * LoginView
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public interface LoginView extends BaseView{

    void onLogingSuccess();
    void onLoginFail();

}
