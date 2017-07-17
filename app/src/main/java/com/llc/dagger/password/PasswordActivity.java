package com.llc.dagger.password;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.llc.dagger.R;
import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.component.DaggerPwdComponent;
import com.llc.dagger.password.component.PwdComponent;
import com.llc.dagger.password.moudle.PwdMoudle;
import com.llc.dagger.password.presenter.IPwdPresenter;
import com.llc.dagger.password.view.PwdView;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

/**
 * com.llc.dagger.password.PasswordActivity
 *
 * @author liulongchao
 * @since 2017/7/14
 */


public class PasswordActivity extends BaseActvity<IPwdPresenter> implements PwdView{


    @Inject
    IPwdPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd);

        PwdComponent build = DaggerPwdComponent.builder().pwdMoudle(new PwdMoudle(this)).build();
        build.injectPasswordActivity(this);

        Password password = presenter.getPassword(build);
        Log.d("MainActivity", "id: "+password.getId());
        Log.d("MainActivity", "pwd: "+password.getPwd());

        Set<Password> passwords = presenter.getPasswords(build);
        Iterator<Password> iterator = passwords.iterator();
        while (iterator.hasNext()){
            Password next = iterator.next();
            Log.d("MainActivity-while", "id: "+next.getId());
            Log.d("MainActivity-while", "pwd: "+next.getPwd());
        }
    }
}
