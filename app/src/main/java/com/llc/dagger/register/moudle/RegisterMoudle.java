package com.llc.dagger.register.moudle;

import com.llc.dagger.login.moudle.Named;
import com.llc.dagger.register.bean.RegisterBean;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LongKey;
import dagger.multibindings.StringKey;

/**
 * com.llc.dagger.register.moudle.RegisterMoudle
 *
 * @author liulongchao
 * @since 2017/7/17
 */

@Module
public class RegisterMoudle {

    /**
     * @IntoMap
     *   将单一元素注入到map中去。map的key可以使用dagger默认的也可以自定义
     *   默认的key有 ClassKey IntKey LongKey StringKey
     *   1.StringKey
     *     参数key为String类型
     * */
    @Provides
    @IntoMap
    @StringKey("StringKey")
    RegisterBean provideRegisterBean(){
        return new RegisterBean("3", "wade");
    }

    /**
     * @IntKey
     *  参数key为int类型
     * */
    @Provides
    @IntoMap
    @IntKey(1)
    RegisterBean provideRegisterBean1(@Named("23")String id, @Named("James")String pwd){
        return new RegisterBean(id, pwd);
    }

    @Provides
    @IntoMap
    @IntKey(2)
    RegisterBean provideRegisterBean2(){
        return new RegisterBean("1", "McGrady");
    }

    /**
     * @LongKey
     *  参数key为long类型
     * */
    @Provides
    @LongKey(1L)
    @IntoMap
    RegisterBean provideRegisterBean3(){
        return new RegisterBean();
    }

    /**
     * @ClassKey
     *  参数key为某个类
     * */
    @Provides
    @IntoMap
    @ClassKey(Named.class)
    RegisterBean provideRegisterBean4(){
        return new RegisterBean("30", "Curry");
    }

    /**
     * 自定义类型
     * 自定义类型有限定范围
     *   1.枚举类型
     *   2.组合类型
     *
     * */
    // 枚举类型
    @Provides
    @IntoMap
    @EnumKey(MyEnum.McGrady)
    RegisterBean provideRegisterBean5(){
        return new RegisterBean("1", MyEnum.McGrady.toString());
    }

    // 组合类型
//    @Provides
//    @IntoMap
//    @ComplexKey(name = "abc", implementingClass = Named.class, thresholds = {1, 5, 10})
//    RegisterBean provideRegisterBean6(){
//        return new RegisterBean("2", MyEnum.Wade.toString());
//   }

    /**
     * 多重绑定
     * 1. 添加一个由@Multibinds注解的抽象方法，该方法的返回值为声明的Set或者Map
     * 2. Dagger从不实现或调用任何@Multibinds方法
     * */
    //@Multibinds
    //abstract Set<RegisterBean> provideRegisterBean6();

    @Provides
    @Named("23")
    String provideId(){
        return "23";
    }

    @Provides
    @Named("James")
    String providePwd(){
        return "James";
    }
}
