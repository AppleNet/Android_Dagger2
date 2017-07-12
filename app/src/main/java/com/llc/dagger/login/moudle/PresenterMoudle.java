package com.llc.dagger.login.moudle;

import com.llc.dagger.login.presenter.ILoginPresenter;
import com.llc.dagger.login.presenter.impl.LoginPresenter;
import com.llc.dagger.login.view.LoginView;
import com.llc.dagger.login.view.LoginViewImpl;

import dagger.Module;
import dagger.Provides;

/**
 * PresenterMoudle
 *
 * @author liulongchao
 * @since 2017/7/4
 */

/**
 *  @Module 可以注解{抽象类}和{普通类}，不可以注解接口
 *  1. 和provide结合使用
 *  2. 提供两个方法includes-{用来提供多个moudles} 和 subcomponent
 * */

@Module
public class PresenterMoudle {

    LoginView loginView;
    public PresenterMoudle(LoginView loginView){
        this.loginView = loginView;
    }

    /**
     *  1.@Provides 不能注解抽象方法，所有个人感觉写抽象类和普通类没什么区别
     *  2.@Provides 不能重复提供
     *  3.@Provides 不能提供空对象，否则将抛出空指针异常
     *  4.abstract class 不能为需求此moule的component提供set方法
     *  5.moudle注解抽象类的时候 编译不会报错，但是拿不到moudle的实例，所以不能 TODO 注解抽象类
     *  6.moudle中不能有方法的重载，否则报错 provideRegisterPresenter() provideRegisterPresenter(RegisterView registerView) 两种写法不行, 编译不通过
     *  7.不能提供重复的对象 provideRegisterPresenter() provideRegisterPresenter(RegisterView registerView) provideRegisterPresenter2(RegisterView registerView) 三种写法都不行
     *    编译不通过 会报错这种错误叫依赖迷失，不知道提供那个实例。此时需要Qualifier（限定符） 来解决这个办法
     *  all-这样写没有意义
     *  8. 注入不能重复注入
     *
     * */

    /**
     *  针对7问题的解决办法
     *
     *  1. 声明@Qualifier注解修饰的 注解类
     *  2. 在提供相同对象的地方 使用此注解 区分
     *  3. 在注入(@Inject)的地方 使用此注解 区分
     * */

    // 非抽象方法 无参数
    @Provides
    @Named("Presenter")
    ILoginPresenter providePresenter() {
        return new LoginPresenter(loginView);
    }

    // 非抽象方法 有参数
    // 1. 自动查找已有@Provides修饰的参数
    // 就会自动找到providesRegisterView 这个方法 拿到这个返回值传递进去
    @Provides
    @Named("Presenter1")
    ILoginPresenter providePresenter1(LoginView loginView){
        return new LoginPresenter(loginView);
    }

    @Provides
    LoginView provideLoginView(){
        return loginView;
    }

    // 2. 通过无参或者有参数构造生成
    // 自动查找LoginViewImpl中 带@Inject的无参构造器并生成实例传入
    @Provides
    @Named("Presenter2")
    ILoginPresenter providePresenter2(LoginViewImpl loginView){
        return new LoginPresenter(loginView);
    }



}
