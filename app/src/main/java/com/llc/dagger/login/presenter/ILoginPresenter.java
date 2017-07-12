package com.llc.dagger.login.presenter;

import com.llc.dagger.base.presenter.BasePresenter;

/**
 * ILoginPresenter
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public interface ILoginPresenter extends BasePresenter {
    void login(String userName, String pwd);
}
