package com.llc.dagger.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.llc.dagger.R;
import com.llc.dagger.base.BaseActvity;
import com.llc.dagger.login.component.DaggerMainActivityComponent;
import com.llc.dagger.login.moudle.PresenterMoudle;
import com.llc.dagger.login.presenter.ILoginPresenter;
import com.llc.dagger.login.view.LoginView;

public class MainActivity extends BaseActvity<ILoginPresenter> implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DaggerMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).build().injectMainactivity(this);
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
    public void showLoaingProgress() {
        Log.d("MainActivity", "showLoaingProgress");
    }

    @Override
    public void dismissLoaingProgess() {
        Log.d("MainActivity", "dismissLoaingProgess");
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
