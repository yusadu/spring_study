package edu.nf.ch15.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 洒度
 * @date 2020/12/8
 */
public class UserServiceAspect implements MethodInterceptor, ThrowsAdvice,
        MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * 后置通知
     * @param o
     * @param method
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("后置通知");
    }

    /**
     * 前置通知
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("前置通知");
    }


    /**
     * 异常通知
     * @param e
     */
    public void afterThrowing(Exception e){
        System.out.println("异常通知："+e.getMessage());
    }

    /**
     * 环绕通知
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕通知前");
        Object returnValue=methodInvocation.proceed();
        System.out.println("环绕通知后");
        return null;
    }
}
