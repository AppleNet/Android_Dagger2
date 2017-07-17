package com.llc.dagger.password.presenter;

import com.llc.dagger.base.presenter.BasePresenter;
import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.component.PwdComponent;

import java.util.Set;

/**
 * com.llc.dagger.password.presenter.IPwdPresenter
 *
 * @author liulongchao
 * @since 2017/7/14
 */


public interface IPwdPresenter extends BasePresenter {
    Password getPassword(PwdComponent build);

    Set<Password> getPasswords(PwdComponent build);
}
