package com.llc.dagger.register.presenter;

import com.llc.dagger.base.presenter.BasePresenter;

/**
 * com.llc.dagger.register.presenter.IRegisterPresenter
 *
 * @author liulongchao
 * @since 2017/7/12
 */


public interface IRegisterPresenter extends BasePresenter {
    boolean resiger(String name, String pwd);
}
