package com.llc.dagger.password.moudle;

import com.llc.dagger.base.view.BaseView;
import com.llc.dagger.password.bean.Password;
import com.llc.dagger.password.presenter.IPwdPresenter;
import com.llc.dagger.password.presenter.impl.PwdPresenter;
import com.llc.dagger.password.view.PwdView;

import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

/**
 * com.llc.dagger.password.moudle.PwdMoudle
 *
 * @author liulongchao
 * @since 2017/7/14
 */

@Module
public class PwdMoudle {


    private BaseView baseView;

    public PwdMoudle(BaseView baseView){
        this.baseView = baseView;
    }

    /**
     *  @IntoSet
     *  将单一元素添加到set集合中
     *   此行为将new Password("1", "123456") 添加到set集合中
     * */
    @Provides
    @IntoSet
    Password providePassword(){
        return new Password("1", "123456");
    }

    /**
     *  @ElementsIntoSet
     *  将多个元素注入到一个集合中
     *  此行为sets.add(new Password("8", "123456"));将一个sets集合添加到另一个sets集合中
     * */
    @Provides
    @ElementsIntoSet
    Set<Password> providePasswords(){
        Set<Password> sets = new HashSet<>();
        sets.add(new Password("1", "123456"));
        sets.add(new Password("2", "123456"));
        sets.add(new Password("3", "123456"));
        sets.add(new Password("4", "123456"));
        sets.add(new Password("5", "123456"));
        sets.add(new Password("6", "123456"));
        sets.add(new Password("7", "123456"));
        sets.add(new Password("8", "123456"));
        return sets;
    }



    @Provides
    IPwdPresenter providePresenter(){
        return new PwdPresenter((PwdView) baseView);
    }

}
