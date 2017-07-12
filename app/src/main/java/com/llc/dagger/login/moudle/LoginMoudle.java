package com.llc.dagger.login.moudle;

import com.llc.dagger.login.model.LoginModel;

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

}
