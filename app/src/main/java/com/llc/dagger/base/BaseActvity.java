package com.llc.dagger.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.llc.dagger.base.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * com.llc.dagger.base.BaseActvity
 *
 * @author liulongchao
 * @since 2017/7/4
 */


public abstract class BaseActvity<P extends BasePresenter> extends AppCompatActivity {

    /**
     * @Inject
     *  1. 可以标记成员变量，但是必须事包级别可见的，不能注入private修饰的变量
     *  2. 查找规则 1.先从Compentent提给的@Provides集合中查找需要注入的对象.
     *             2 如果1找不到 就从@Component提供的dependencies中查找
     *             3. 如果2查找不到 就去找对应的成员变量又@Inject注解的构造方法查找
     *
     * */
    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
