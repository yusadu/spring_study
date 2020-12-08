package edu.nf.ch16.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author 洒度
 * @date 2020/12/8
 */
public class UserServiceAspect {

    /**
     * 前置通知
     * @param jp 连接点实例,可以后去目标方法信息
     */
    public void before(JoinPoint jp){
        System.out.println("前置通知...,参数1："+jp.getArgs()[0]);
    }

    /**
     * 环绕通知
     * @param pjp 连接点实例，继承自JoinPoint
     *            可以获取目标方法参数，方法信息，以及调用目标方法等
     * @return
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知前");
        //获取目标方法的Method对象
        MethodSignature ms=(MethodSignature)pjp.getSignature();
        Method method=ms.getMethod();
        System.out.println("当前调用的目标方法："+method.getName());
        //调用目标方法
        Object returnValue=pjp.proceed();
        System.out.println("环绕通知后");
        return returnValue;
    }

    /**
     * 后置通知，一旦产生异常，后置通知不会被执行
     * @param jp 连接点实例
     * @param returnValue 目标方法的返回值
     */
    public void afterReturning(JoinPoint jp , String returnValue){
        System.out.println("后置通知，返回值："+returnValue);
    }

    /**
     * 异常通知
     * @param jp 连接点实例
     * @param e 目标方法产生的异常对象
     */
    public void afterThrowing(JoinPoint jp,Exception e){
        System.out.println("异常通知："+e.getMessage());
    }

    /**
     * 最终通知，不管有没有异常产生都会执行最终通知
     * @param jp
     */
    public void after(JoinPoint jp){
        System.out.println("最终通知");
    }

}
