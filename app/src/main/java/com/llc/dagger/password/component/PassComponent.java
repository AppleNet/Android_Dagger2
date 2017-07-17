package com.llc.dagger.password.component;

import com.llc.dagger.password.moudle.PassMoudle;
import com.llc.dagger.password.presenter.impl.PwdPresenter;

import dagger.Component;

/**
 * com.llc.dagger.password.component.PassComponent
 *
 * @author liulongchao
 * @since 2017/7/14
 */

@Component(modules = PassMoudle.class)
public interface PassComponent {

    void injectPresenter(PwdPresenter pwdPresenter);

}
