package com.llc.dagger.android.activity.component;

import com.llc.dagger.android.AndroidActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * com.llc.dagger.android.activity.component.AdnroidSubComponent
 *
 * @author liulongchao
 * @since 2017/7/18
 */

@Subcomponent(modules = AndroidInjectionModule.class)
public interface AdnroidSubComponent extends AndroidInjector<AndroidActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AndroidActivity>{

    }
}
