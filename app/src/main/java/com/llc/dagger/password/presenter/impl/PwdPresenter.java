package com.llc.dagger.password.presenter.impl;

import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.component.DaggerPassComponent;
import com.llc.dagger.password.component.PassComponent;
import com.llc.dagger.password.component.PwdComponent;
import com.llc.dagger.password.model.PwdModel;
import com.llc.dagger.password.moudle.PassMoudle;
import com.llc.dagger.password.presenter.IPwdPresenter;
import com.llc.dagger.password.view.PwdView;

import java.util.Set;

import javax.inject.Inject;

/**
 * com.llc.dagger.password.presenter.impl.PwdPresenter
 *
 * @author liulongchao
 * @since 2017/7/14
 */


public class PwdPresenter implements IPwdPresenter {


    private PwdView pwdView;

    @Inject
    PwdModel pwdModel;

    public PwdPresenter(PwdView pwdView){
        this.pwdView = pwdView;
        PassComponent passComponent = DaggerPassComponent.builder().passMoudle(new PassMoudle()).build();
        passComponent.injectPresenter(this);
    }

    @Override
    public Password getPassword(PwdComponent build) {
        pwdView.showLoaingProgress();
        pwdView.dismissLoaingProgess();
        return pwdModel.getPwd(build);
    }

    @Override
    public Set<Password> getPasswords(PwdComponent build) {
        return pwdModel.getPwds(build);
    }

}
