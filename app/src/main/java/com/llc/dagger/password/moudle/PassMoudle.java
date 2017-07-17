package com.llc.dagger.password.moudle;

import com.llc.dagger.password.model.PwdModel;

import dagger.Module;
import dagger.Provides;

/**
 * com.llc.dagger.password.moudle.PassMoudle
 *
 * @author liulongchao
 * @since 2017/7/14
 */

@Module
public class PassMoudle {

    @Provides
    PwdModel providePwdModel(){
        return new PwdModel();
    }
}
