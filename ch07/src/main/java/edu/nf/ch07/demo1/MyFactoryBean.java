package edu.nf.ch07.demo1;

import edu.nf.ch07.demo1.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 洒度
 * @date 2020/12/2
 * 自定义FactoryBean，用于创建自定义对象
 * Spring容器会调用FactoryBean的getObject方法，
 * 将返回对象自动纳入IOC容器中
 */
public class MyFactoryBean implements FactoryBean<UserService> {

    /**
     * 返回具体的某个实现类
     * @return
     * @throws Exception
     */
    @Override
    public UserService getObject() throws Exception {
        return new UserServiceImpl();
    }

    /**
     * 返回Bean的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return UserServiceImpl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
