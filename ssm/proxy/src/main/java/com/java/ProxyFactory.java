package com.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        /*
        * ClassLoader loader:指定加载动态生成的代理类的类加载器
        * Class[] interfaces:获取目标对象实现的所有接口的class对象的数组
        * InvocationHandler h:设置代理类中的抽象方法如何重写
        * */
        Class<?>[] interfaces = target.getClass().getInterfaces();
        ClassLoader classLoader = this.getClass().getClassLoader();
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志，方法:"+method.getName()+",参数"+ Arrays.toString(args));
                //proxy:标识代理对象
                //method:表示要执行的方法
                //args:表示要执行方法的参数列表
                Object result = method.invoke(target, args);
                System.out.println("日志，方法"+method.getName()+",结果："+result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);


    }
}
