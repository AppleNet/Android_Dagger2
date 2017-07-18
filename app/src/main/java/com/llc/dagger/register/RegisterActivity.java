package com.llc.dagger.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.llc.dagger.R;
import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.login.component.DaggerMainActivityComponent;
import com.llc.dagger.login.moudle.AbsPresenterMoudle;
import com.llc.dagger.login.moudle.Named;
import com.llc.dagger.login.moudle.PresenterMoudle;
import com.llc.dagger.register.bean.RegisterBean;
import com.llc.dagger.register.component.DaggerRegisterComponent;
import com.llc.dagger.register.component.RegisterComponent;
import com.llc.dagger.register.moudle.MyEnum;
import com.llc.dagger.register.moudle.RegisterMoudle;
import com.llc.dagger.register.presenter.IRegisterPresenter;
import com.llc.dagger.register.view.RegisterView;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * com.llc.dagger.register.RegisterActivity
 *
 * @author liulongchao
 * @since 2017/7/12
 */


public class RegisterActivity extends BaseActvity<IRegisterPresenter> implements RegisterView {

    // lazy provider

    // lazy 延迟加载 可以用于@Inject延迟加载属性  也可以用于compontent中延迟加载方法
    // 通过调用get() 方法进行创建，只有在调用get的时候 才会初始化
    // 以后每次调用get的时候 都会得到同一个对象
    @Inject
    @Named("presenterRegister")
    protected Lazy<IRegisterPresenter> persenterLazy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DaggerMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).absPresenterMoudle(new AbsPresenterMoudle(this)).build().injectRegisterActivity(this);

        IRegisterPresenter presenter = persenterLazy.get();
        presenter.resiger("wade", "34");

        RegisterComponent build = DaggerRegisterComponent.builder().registerMoudle(new RegisterMoudle()).build();
        Map<String, RegisterBean> stringRegisterBeanMap = build.registerByString();
        for (RegisterBean registerBean : stringRegisterBeanMap.values()){
            Log.d("MainActivity", "id-string: "+registerBean.getId());
            Log.d("MainActivity", "pwd-string: "+registerBean.getPwd());
        }

        Map<Integer, RegisterBean> integerRegisterBeanMap = build.registerByInt();
        Set<Integer> integers = integerRegisterBeanMap.keySet();
        for (Integer  integer : integers){
            Log.d("MainActivity", "id-key: " + integer + "，id-value: " + integerRegisterBeanMap.get(integer).getId());
            Log.d("MainActivity", "pwd-key: " + integer + "，pwd-value: " + integerRegisterBeanMap.get(integer).getPwd());
        }

        Map<Long, RegisterBean> longRegisterBeanMap = build.registerByLong();
        Set<Long> longs = longRegisterBeanMap.keySet();
        for (Long l : longs){
            Log.d("MainActivity", "id-long-key: " + l + "，id-long-value: " + longRegisterBeanMap.get(l).getId());
            Log.d("MainActivity", "pwd-long-key: " + l + "，pwd-long-value: " + longRegisterBeanMap.get(l).getPwd());
        }

        Map<Class<?>, RegisterBean> classRegisterBeanMap = build.registerByClass();
        Set<Map.Entry<Class<?>, RegisterBean>> entries = classRegisterBeanMap.entrySet();
        for (Map.Entry<Class<?>, RegisterBean> entry : entries) {
            Log.d("MainActivity", "id-class-key: " + entry.getKey().toString() + "，id-class-value: " + entry.getValue().getId());
            Log.d("MainActivity", "pwd-class-key: " + entry.getKey().toString() + "，pwd-class-value: " + entry.getValue().getPwd());
        }

        Map<MyEnum, RegisterBean> myEnumRegisterBeanMap = build.registerByEnum();
        Set<Map.Entry<MyEnum, RegisterBean>> entries1 = myEnumRegisterBeanMap.entrySet();
        for (Map.Entry<MyEnum, RegisterBean> myEnumRegisterBeanEntry : entries1) {
            Log.d("MainActivity", "id-enum-key: " + myEnumRegisterBeanEntry.getKey().toString() + "，id-enum-value: " + myEnumRegisterBeanEntry.getValue().getId());
            Log.d("MainActivity", "pwd-enum-key: " + myEnumRegisterBeanEntry.getKey().toString() + "，pwd-enum-value: " + myEnumRegisterBeanEntry.getValue().getPwd());
        }


//        build.registerBycomplex().get(createComplexKey("abc", Named.class, new int[] {1, 5, 10}));

    }

//    @AutoAnnotation
//    static ComplexKey createComplexKey(String name, Class<?> implementingClass, int[] thresholds){
//        return new AutoAnnotation_RegisterMoudle(name, implementingClass, thresholds);
//    }

}
