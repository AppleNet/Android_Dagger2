package com.llc.dagger.app;

import android.app.Activity;
import android.app.Application;

import com.llc.dagger.android.activity.component.DaggerAndroidComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * com.llc.dagger.app.MyApplication
 *
 * @author liulongchao
 * @since 2017/7/18
 */


public class MyApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAndroidComponent.builder().build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
