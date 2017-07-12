package com.llc.dagger.login.model;

import android.util.Log;

import com.llc.dagger.base.model.BaseModel;

import javax.inject.Inject;

/**
 * LoginModel
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public class LoginModel implements BaseModel{

    @Inject
    public LoginModel(){

    }

    public void doLogin(String userName, String pwd){
        // do login
        Log.d("MainActivity", "userName: "+userName+",pwd: "+pwd);
    }
}
