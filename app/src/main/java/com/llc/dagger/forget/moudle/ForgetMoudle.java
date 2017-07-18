package com.llc.dagger.forget.moudle;

import com.llc.dagger.forget.bean.Forget;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * com.llc.dagger.forget.moudle.ForgetMoudle
 *
 * @author liulongchao
 * @since 2017/7/18
 */

@Module
public class ForgetMoudle {

    /**
     * @Singleton
     *  1.作用域，scope的特殊实现<单例> 在moudle中作用在@Provides 方法上将返回类型处理成单例。
     *  2.component也要使用此注解 才能生效 否则将会抛出异常
     *  3.@Singleton也可以作用在实体bean上。component也要使用此注解 才能生效 否则将会抛出异常
     *  4.有些博客说 在实体bean的类上加@Singleton 也生效 但是在最新的dagger2.11上 如果提供了@Provides 但是@Provides没有声明@Singleton 此时单例不生效
     *  5.@Component(modules = ForgetMoudle.class) 此时moudle中的@Provides方法必须使用@Singleton 不使用编译不会报错 但是单例不生效
     *  6.Scope控制的实例的注入器是当前Component之内的实例注入器，而不会影响其他的Component中的实例注入器
     * */
    @Singleton
    @Provides
    Forget provideForget(){
        return new Forget();
    }

}
