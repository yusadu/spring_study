package edu.nf.ch13.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 洒度
 * @date 2020/12/7
 * 回调处理器，负责调用目标对象的方法
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    /**
     * 通过构造方法传入目标对象
     * @param target
     */
    public LogInvocationHandler(Object target){
        this.target=target;
    }

    /**
     *
     * @param proxy 运行时创建的代理对象
     * @param method 当前目标对象正在调用的方法
     * @param args 目标方法所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用当前对象的方法，需要传入一个目标对象的实例
        Object returnValue=method.invoke(target,args);
        //目标方法执行完成后调用日志方法记录操作
        log();
        return returnValue;
    }

    private void log(){
        System.out.println("执行日志记录操作...");
    }
}
