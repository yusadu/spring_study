package edu.nf.ch08.factorybean;

import edu.nf.ch08.util.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 洒度
 * @date 2020/12/2
 * 通过自定义FactoryBean来创建mybaits的mapper接口代理对象
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    /**
     * 由于动态代理创建代理对象时需要传入一个接口
     * 而这个接口可以通过set方法注入进来
     */
    private Class<T> daoInterface;

    /**
     * 提供一个set方法注入一个Dao的接口的Class对象
     * @param daoInterface
     */
    public void setDaoInterface(Class<T> daoInterface){
        this.daoInterface=daoInterface;
    }

    /**
     * 当IOC容器调用getObject方法时，返回的是SQLSession的getMapper的代理对象，
     * 这个代理对象就可以纳入容器中管理
     * @return
     * @throws Exception
     */
    @Override
    public T getObject() throws Exception {
        SqlSession sqlSession= MybatilsUtils.getSqlSession();
        T mapperProxy=sqlSession.getMapper(daoInterface);
        return mapperProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return daoInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
