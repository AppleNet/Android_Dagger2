package com.llc.dagger.login.component;

import com.llc.dagger.login.MainActivity;
import com.llc.dagger.login.moudle.PresenterMoudle;
import com.llc.dagger.login.presenter.ILoginPresenter;

import javax.inject.Provider;

import dagger.Component;
import dagger.Lazy;
import dagger.MembersInjector;

/**
 * MainActivityComponent
 *
 * @author liulongchao
 * @since 2017/7/4
 */

/**
 * @Compontent
 *  1. 可以修饰接口和抽象类
 *  2. 编译之后 生成对应的DaggerMainActivityComponent类 实现MainActivityComponent这个接口
 *  3. 通过建造者模式，调用DaggerMainActivityComponent.builder()获取Buidler实例，调用presenterMoudle(PresenterMoudle presenterMoudle)方法获取PresenterMoudle类的实例。
 *     调用build()方法 获取MainActivityComponent这个实例，调用injectMainactivity 进行注入
 *
 *     1. 一种是有参数的void修饰的方法 Members-injection methods have a single parameter and inject dependencies into each of the Inject-annotated fields and methods of the passed instance.
 *          A members-injection method may be void or return its single parameter as a convenience for chaining
 *
 *     2. 有返回值 无参数的方法 Provision methods have no parameters and return an injected or provided type
 *
 *     3. 具体实现
 *     @Override
       public ILoginPresenter injectMainActivity() {
           return providePresenterProvider.get();
       }

       @Override
       public void injectMainactivity(MainActivity mainActivity) {
          mainActivityMembersInjector.injectMembers(mainActivity);
       }

       @Override
       public MainActivity injectMainActivity(MainActivity mainActivity) {
          mainActivityMembersInjector.injectMembers(mainActivity);
          return mainActivity;
       }

       @Override
       public MembersInjector<MainActivity> getMainActivityInjector() {
         return mainActivityMembersInjector;
       }
 *
 * */

@Component(modules = PresenterMoudle.class)
public interface MainActivityComponent {

    /**
     * 两种方式
     * */

    /* 第一种*/
    // 无参数 有返回值 返回注入的类型或者提供的类型
    ILoginPresenter injectMainActivity();
    // 拓展 Provision methods, like typical injection sites, may use Provider or Lazy to more explicitly control provision requests
    // 规定方法，类似典型的injection sites 可以使用Provider或者lazy修饰 更准确的控制请求
    Lazy<ILoginPresenter> getLazyMainActivityInjector();
    Provider<ILoginPresenter> getProviderMainActivityInjector();


    /*第二种*/

    // 有参数 void
    void injectMainactivity(MainActivity mainActivity);
    // 有参数 返回参数类型的方法
    MainActivity injectMainActivity(MainActivity mainActivity);
    // 无参数 返回MembersInjector 等价于 有参数 void
    MembersInjector<MainActivity> getMainActivityInjector();

}
