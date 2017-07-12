package com.llc.dagger.login.component;

import com.llc.dagger.login.MainActivity;
import com.llc.dagger.login.moudle.AbsPresenterMoudle;
import com.llc.dagger.login.moudle.PresenterMoudle;

import dagger.Component;

/**
 * com.llc.dagger.login.component.AbsMainActivityComponent
 *
 * @author liulongchao
 * @since 2017/7/12
 */

/**
 *  @Component修饰抽象类
 *    1. moudles 可以使用单个 moudles = PresenterMoudle.class
 *       也可以使用modules = {PresenterMoudle.class} 来关联多个moudle
 *    2. 拓展
 *       1. 使用subcomponent
 *       2. 使用dependencies
 * */
@Component(modules = {AbsPresenterMoudle.class, PresenterMoudle.class})
public abstract class AbsMainActivityComponent {

    abstract void getMainActivity(MainActivity mainActivity);

    // 一。 subcomponent
    // 1. 创建接口或者抽象类 用@Subcomponent 来声明为sub component
    // 2. 在sub component中 必须用注解@Subcomponent.Builder来显示的声明sub component的builder 用来获取MainActivitySubComponent
    // 3. 需要在 parent component中创建子component, 通过获取MainActivitySubComponent.Builder来拿到sub component
    // 4. SubComponent 编译时不会生成 DaggerXXComponent，需要通过 parent Component 的获取 SubComponent.Builder 方法获取 SubComponent 实例
    // 5. DaggerAbsMainActivityComponent.builder().presenterMoudle(new PresenterMoudle(this)).build().mainactivitySubComponent().build(); 调整方式
    public abstract MainActivitySubComponent.Builder mainactivitySubComponent();

}
