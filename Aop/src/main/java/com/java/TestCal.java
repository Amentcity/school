package com.java;

public class TestCal {
    public static void main(String[] args) {
        //创建的代理对象(动态)
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
//        proxy.add(1,2);
        proxy.mul(2,4);
    }
}
