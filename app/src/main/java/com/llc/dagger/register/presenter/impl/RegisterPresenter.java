package com.llc.dagger.register.presenter.impl;

import com.llc.dagger.register.presenter.IRegisterPresenter;
import com.llc.dagger.register.view.RegisterView;

import javax.inject.Inject;

/**
 * com.llc.dagger.register.presenter.impl.RegisterPresenter
 *
 * @author liulongchao
 * @since 2017/7/12
 */


public class RegisterPresenter implements IRegisterPresenter {

    private RegisterView registerView;

    @Inject
    public RegisterPresenter(RegisterView registerView){
        this.registerView = registerView;
    }

    @Override
    public boolean resiger(String name, String pwd) {
        return false;
    }
}
