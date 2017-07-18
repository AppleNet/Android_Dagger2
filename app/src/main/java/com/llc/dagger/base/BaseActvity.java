package com.llc.dagger.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.llc.dagger.base.presenter.BasePresenter;
import com.llc.dagger.base.view.BaseView;

/**
 * com.llc.dagger.base.BaseActvity
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public abstract class BaseActvity<P extends BasePresenter> extends AppCompatActivity implements BaseView {


    protected P presenter;
    protected final String TAG = BaseActvity.class.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoaingProgress() {
        Log.d("MainActivity", "showLoaingProgress");
    }

    @Override
    public void dismissLoaingProgess() {
        Log.d("MainActivity", "dismissLoaingProgess");
    }

}
