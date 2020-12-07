package edu.nf.ch13.jdk;

import edu.nf.ch13.UserService;
import edu.nf.ch13.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 洒度
 * @date 2020/12/7
 */
public class Main {

    public static void main(String[] args) {
        //创建代理满足的必要条件
        //创建回调处理器，并传入目标对象
        InvocationHandler handler=new LogInvocationHandler(new UserServiceImpl());
        //获取一个类加载器，用于加载动态创建处理的代理字节码
        //加载成功后自动创建出一个代理实例
        ClassLoader loader=Main.class.getClassLoader();
        //获取目标对象索实现的接口的Class
        Class[] classes= UserServiceImpl.class.getInterfaces();

        //使用Proxy类来创建代理对象,并且创建处理的代理对象会自动实现上面的接口
        UserService service=(UserService) Proxy.newProxyInstance(loader,classes,handler);
        service.add();
    }
}
