package com.llc.dagger.forget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.llc.dagger.R;
import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.forget.bean.Forget;
import com.llc.dagger.forget.component.DaggerForgetComponent;

import javax.inject.Inject;

/**
 * com.llc.dagger.forget.ForgetActivity
 *
 * @author liulongchao
 * @since 2017/7/18
 */


public class ForgetActivity extends BaseActvity {

    @Inject
    Forget forget;
    @Inject
    Forget forget1;
    @Inject
    Forget forget2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        DaggerForgetComponent.builder().build().inject(this);

        Log.d("MainActivity", "forget:" + forget.toString());
        Log.d("MainActivity", "forget1:" + forget1.toString());
        Log.d("MainActivity", "forget2:" + forget2.toString());
    }
}
