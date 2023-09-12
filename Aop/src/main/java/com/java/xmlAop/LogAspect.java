package com.java.xmlAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //切面类
@Component  //ioc容器
public class LogAspect {
    //前置通知
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger---->前置通知,方法名称"+name+",参数"+ Arrays.toString(args));
    }
    //返回通知 获取目标方法的返回值
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->返回通知,方法名称"+name+"，返回结果"+result);
    }
    // 异常通知
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->返回通知,方法名称"+name+",异常信息"+ex);
    }
    // 后置通知
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->后置通知,方法名称"+name);
    }
    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String string = Arrays.toString(args);
        Object proceed = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            //调用目标方法
            proceed = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        } finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return proceed;
    }
    //重用切入掉表达式
    @Pointcut(value = "execution(* com.java.xmlAop.CalculatorImpl.*(..))")
    public void pointcut(){

    }

}
