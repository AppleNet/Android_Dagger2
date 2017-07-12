package com.llc.dagger.login.moudle;

import com.llc.dagger.base.view.BaseView;
import com.llc.dagger.register.presenter.IRegisterPresenter;
import com.llc.dagger.register.presenter.impl.RegisterPresenter;
import com.llc.dagger.register.view.RegisterView;

import dagger.Module;
import dagger.Provides;

/**
 * com.llc.dagger.login.moudle.AbsPresenterMoudle
 *
 * @author liulongchao
 * @since 2017/7/12
 */
/**
 *  @Module 可以注解{抽象类}和{普通类}，不可以注解接口
 *
 *  1.@Provides 不能注解抽象方法，所有个人感觉写抽象类和普通类没什么区别
 *  2.@Provides 不能重复提供
 *  3.@Provides 不能提供空对象，否则将抛出空指针异常
 *  4.abstract class 不能为需求此moule的component提供set方法
 *  5.moudle注解抽象类的时候 编译不会报错，但是拿不到moudle的实例，所以不能 TODO 注解抽象类
 *  6.moudle中不能有方法的重载，否则报错 provideRegisterPresenter() provideRegisterPresenter(RegisterView registerView) 两种写法不行, 编译不通过
 *  7.不能提供重复的对象 provideRegisterPresenter() provideRegisterPresenter(RegisterView registerView) provideRegisterPresenter2(RegisterView registerView) 三种写法都不行
 *    编译没有问题 但是运行的时候 会报错这种错误叫依赖迷失，不知道提供那个实例
 *  all-这样写没有意义
 * */
@Module
public class AbsPresenterMoudle {

    private BaseView baseView;

    public AbsPresenterMoudle(BaseView baseView){
        this.baseView = baseView;
    }

//    抽象方法
//    @Provides
//    public abstract RegisterPresenter provideRegisterPresenter();

    // 非抽象方法 无参数
    @Provides
    @Named("presenterRegister")
    IRegisterPresenter provideRegisterPresenter(){
        return new RegisterPresenter((RegisterView) baseView);
    }

//    @Provides
//    IRegisterPresenter provideRegisterPresenter(RegisterView registerView){
//        return new RegisterPresenter(registerView);
//    }

    // 非抽象方法 有参数
    // 1. 自动查找已有@Provides修饰的参数
    // 就会自动找到providesRegisterView 这个方法 拿到这个返回值传递进去
    @Provides
    @Named("presenterRegister2")
    IRegisterPresenter provideRegisterPresenter2(RegisterView registerView){
        return new RegisterPresenter(registerView);
    }

    @Provides
    RegisterView providesRegisterView(){
        return (RegisterView) baseView;
    }

}
