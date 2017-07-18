package com.llc.dagger.android.activity.moudle;

import android.app.Activity;

import com.llc.dagger.android.AndroidActivity;
import com.llc.dagger.android.activity.component.AdnroidSubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * com.llc.dagger.android.activity.moudle.AndroidMoudle
 *
 * @author liulongchao
 * @since 2017/7/18
 */

@Module(subcomponents = AdnroidSubComponent.class)
public abstract class AndroidMoudle {

    @Binds
    @IntoMap
    @ActivityKey(AndroidActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindBaseActivityInjectorFactory(AdnroidSubComponent.Builder builder);
}
