package com.llc.dagger.register.presenter.impl;

import com.llc.dagger.login.component.DaggerLoginPresenterComponent;
import com.llc.dagger.login.moudle.LoginMoudle;
import com.llc.dagger.register.model.RegisterModel;
import com.llc.dagger.register.presenter.IRegisterPresenter;
import com.llc.dagger.register.view.RegisterView;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * com.llc.dagger.register.presenter.impl.RegisterPresenter
 *
 * @author liulongchao
 * @since 2017/7/12
 */


public class RegisterPresenter implements IRegisterPresenter {

    private RegisterView registerView;

    // Lazy Provider
    // Provider
    // 通过调用get() 方法进行创建，只有在调用get的时候 才会初始化
    // 以后每次调用get方法会强制调用Moudle的Provides方法一次
    // 根据Provides具体实现不同，可能返回同一个对象，可能返回非同一个对象
    // 只有Provides的方法每次都创建新实例时，返回的对象不相同。
    // 使用MembersInjector的时候 不能结合使用Provider 一起使用
    @Inject
    Provider<RegisterModel> model;

    @Inject
    public RegisterPresenter(RegisterView registerView){
        this.registerView = registerView;
        DaggerLoginPresenterComponent.builder().loginMoudle(new LoginMoudle()).build().injectRegisterModel(this);
        //DaggerLoginPresenterComponent.builder().loginMoudle(new LoginMoudle()).build().injectRegisterModel().injectMembers(this);
    }

    @Override
    public boolean resiger(String name, String pwd) {
        registerView.showLoaingProgress();
        boolean flag = model.get().register(name, pwd);
        registerView.dismissLoaingProgess();
        return flag;
    }
}
