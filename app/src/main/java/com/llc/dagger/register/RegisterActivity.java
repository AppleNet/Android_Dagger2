package com.llc.dagger.register;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.login.component.DaggerMainActivityComponent;
import com.llc.dagger.login.moudle.AbsPresenterMoudle;
import com.llc.dagger.login.moudle.Named;
import com.llc.dagger.login.moudle.PresenterMoudle;
import com.llc.dagger.register.presenter.IRegisterPresenter;
import com.llc.dagger.register.view.RegisterView;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * com.llc.dagger.register.RegisterActivity
 *
 * @author liulongchao
 * @since 2017/7/12
 */


public class RegisterActivity extends BaseActvity<IRegisterPresenter> implements RegisterView {

    // lazy provider

    // lazy 延迟加载 可以用于@Inject延迟加载属性  也可以用于compontent中延迟加载方法
    // 通过调用get() 方法进行创建，只有在调用get的时候 才会初始化
    // 以后每次调用get的时候 都会得到同一个对象
    @Inject
    @Named("presenterRegister")
    protected Lazy<IRegisterPresenter> persenterLazy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).absPresenterMoudle(new AbsPresenterMoudle(this)).build().injectRegisterActivity(this);

        IRegisterPresenter presenter = persenterLazy.get();
        presenter.resiger("wade", "34");
    }

}
