package com.llc.dagger.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.llc.dagger.R;
import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.login.component.DaggerMainActivityComponent;
import com.llc.dagger.login.moudle.AbsPresenterMoudle;
import com.llc.dagger.login.moudle.Named;
import com.llc.dagger.login.moudle.PresenterMoudle;
import com.llc.dagger.login.presenter.ILoginPresenter;
import com.llc.dagger.login.view.LoginView;
import com.llc.dagger.password.PasswordActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActvity<ILoginPresenter> implements LoginView{

    /**
     * @Inject
     *  1. 可以标记成员变量，但是必须事包级别可见的，不能注入private修饰的变量
     *  2. 查找规则 1.先从Compentent提给的@Provides集合中查找需要注入的对象.
     *             2 如果1找不到 就从@Component提供的dependencies中查找
     *             3. 如果2查找不到 就去找对应的成员变量又@Inject注解的构造方法查找
     *
     * */
    @Inject
    @Named("Presenter")
    ILoginPresenter presenter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DaggerMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).absPresenterMoudle(new AbsPresenterMoudle(this)).build().injectMainactivity(this);
        // TODO sub component的调用方式
        //DaggerAbsMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).build().mainactivitySubComponent().build();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        presenter.login("McGrady","32");

        textView = (TextView) findViewById(R.id.text);
        RxView.clicks(textView).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        //startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                        startActivity(new Intent(MainActivity.this, PasswordActivity.class));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLogingSuccess() {
        Log.d("MainActivity", "onLogingSuccess");
    }

    @Override
    public void onLoginFail() {
        Log.d("MainActivity", "onLoginFail");
    }
}
