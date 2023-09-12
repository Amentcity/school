package com.java.annoAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //切面类
@Component  //ioc容器
public class LogAspect {
    //设置切入点和通知类型
    //切入点表达式execution(访问修饰符 增强方法返回类型 增强方法所在类的全路径 方法名称(方法参数))
    //通知类型：
    // 前置@Before(value="切入点表达式配置切入点")
    @Before(value = "execution(public int com.java.annoAop.CalculatorImpl.add(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger---->前置通知,方法名称"+name+",参数"+ Arrays.toString(args));
    }
    // 返回@AfterReturning
    @AfterReturning(value = "execution(* com.java.annoAop.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->返回通知,方法名称"+name+"，返回结果"+result);
    }
    // 异常@AfterThrowing
    //目标方法出现异常，这个通知执行
    @AfterThrowing(value = "execution(* com.java.annoAop.CalculatorImpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->返回通知,方法名称"+name+",异常信息"+ex);
    }
    // 后置@After()
//    @After(value = "com.java.annoAop.LogAspect.pointcut()")  //不同切面
    @After(value = "pointcut()")  //统一切面
    public void afterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("Logger---->后置通知,方法名称"+name);
    }
    // 环绕@Around()
    @Around(value = "execution(* com.java.annoAop.CalculatorImpl.*(..))")
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
    @Pointcut(value = "execution(* com.java.annoAop.CalculatorImpl.*(..))")
    public void pointcut(){

    }

}
