package com.java.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的方法的方法名
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",参数"+Arrays.toString(args));
    }
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的方法的方法名
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，执行完毕");
    }
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+",结果："+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception ex){
        String name = joinPoint.getSignature().getName();
        System.out.println("LoggerAspect,方法："+name+",异常通知"+ex);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result= joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
