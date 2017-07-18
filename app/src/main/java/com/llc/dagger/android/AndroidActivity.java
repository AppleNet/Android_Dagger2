package com.llc.dagger.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dagger.android.AndroidInjection;

/**
 * com.llc.dagger.android.AndroidActivity
 *
 * @author liulongchao
 * @since 2017/7/18
 */


public class AndroidActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        /***
         *  AndroidInjection.inject(this);
         *  这种写法 其实是在Application中注入
         *  在此Activity中不需要在写DaggerXXXComponent.builder().<presenterMoudle()>.inject(this)
         *  不需要知道一个类是如何注入的
         *  但是需要在Application提供每一个Activity的component和moudle
         *  其实是将所有的Activity的component和moudle 注入到Application的map中 然后从map获取对应的实例
         * */
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);


    }
}
