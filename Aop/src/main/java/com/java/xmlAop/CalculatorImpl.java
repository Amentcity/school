package com.java.xmlAop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        System.out.println("方法内部result="+result);
        //为了测试模拟异常出现
//        int a=1/0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        System.out.println("方法内部result="+result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        System.out.println("方法内部result="+result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        System.out.println("方法内部result="+result);
        return result;
    }
}
