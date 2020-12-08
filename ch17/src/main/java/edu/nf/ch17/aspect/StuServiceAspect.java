package edu.nf.ch17.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author 洒度
 * @date 2020/12/8
 * @Aspect注解标注当前类为一个切面
 * @Component注解标识为容器管理
 */
@Aspect
@Component
public class StuServiceAspect {

    /**
     * 定义切入点，只能给定义一个方法，不需要任何逻辑
     * 此方法仅仅适用于给@Pointcut注解标注，用于声明切入点表达式
     */
    @Pointcut("execution(* edu.nf.ch17.service.impl.*.*(..))")
    public void myPointcut(){}

    /**
     * 前置通知
     * @param jp
     */
    @Before("myPointcut()")
    public void before (JoinPoint jp){
        System.out.println("前置通知，参数："+jp.getArgs()[0]);
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知前");
        //调用目标方法
        Object returnValue=pjp.proceed();
        System.out.println("环绕通知后");
        return returnValue;
    }

    /**
     * 后置通知
     * @param jp
     * @param returnValue
     */
    @AfterReturning(value = "myPointcut()",returning = "returnValue")
    public void afterReturning(JoinPoint jp,String returnValue){
        System.out.println("后置通知，返回值："+returnValue);
    }

    /**
     * 异常通知
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "myPointcut()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        System.out.println("异常通知，异常："+e.getMessage());
    }

    /**
     * 最终通知
     * @param jp
     */
    @After("myPointcut()")
    public void after(JoinPoint jp){
        System.out.println("最终通知");
    }
}
