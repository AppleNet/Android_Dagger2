package com.llc.dagger.android.activity.component;

import com.llc.dagger.android.activity.moudle.AndroidMoudle;
import com.llc.dagger.app.MyApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * com.llc.dagger.android.activity.component.AndroidComponent
 *
 * @author liulongchao
 * @since 2017/7/18
 */

@Component(modules = {AndroidInjectionModule.class, AndroidMoudle.class})
public interface AndroidComponent {
    void inject(MyApplication myApplication);
}
