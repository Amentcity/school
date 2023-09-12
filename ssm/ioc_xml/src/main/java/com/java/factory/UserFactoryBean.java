package com.java.factory;

import com.java.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/*
* 1.FactoryBean是一个接口，需要创建一个类实现该接口
* 其中方法有三个
* getObject：提供一个对象交给IOC容器管理
*  getObjectType():设置多提供对象的类型
* isSingleton():所提供的对象是否单例
* 当把FactoryBean的实现类配置为bean时会将将当前类中getObject()方法所返回的对象交给IOC容器来管理
* */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
