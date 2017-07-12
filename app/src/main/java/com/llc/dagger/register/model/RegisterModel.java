package com.llc.dagger.register.model;

import android.util.Log;

import com.llc.dagger.base.model.BaseModel;

/**
 * com.llc.dagger.register.model.RegisterModel
 *
 * @author liulongchao
 * @since 2017/7/12
 */

public class RegisterModel implements BaseModel {

    public boolean register(String name, String pwd){
        // do register
        Log.d("MainActivity", "name: "+name);
        Log.d("MainActivity", "pwd: "+pwd);
        return true;
    }
}
