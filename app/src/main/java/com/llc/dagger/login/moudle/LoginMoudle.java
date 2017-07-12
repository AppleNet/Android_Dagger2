package com.llc.dagger.login.moudle;

import com.llc.dagger.login.model.LoginModel;
import com.llc.dagger.register.model.RegisterModel;

import dagger.Module;
import dagger.Provides;

/**
 * LoginMoudle
 *
 * @author liulongchao
 * @since 2017/7/4
 */

@Module
public class LoginMoudle {

    @Provides
    LoginModel provideLoginModel(){
        return new LoginModel();
    }

    @Provides
    RegisterModel provideRegisterModel(){
        return new RegisterModel();
    }
}
