package com.llc.dagger.forget.presenter;

import com.llc.dagger.base.presenter.BasePresenter;

/**
 * com.llc.dagger.forget.presenter.IForgetPresenter
 *
 * @author liulongchao
 * @since 2017/7/18
 */


public interface IForgetPresenter extends BasePresenter {
    void forget(String name, String pwd);
}
