package edu.nf.ch05.service.impl;

import edu.nf.ch05.dao.UserDao;
import edu.nf.ch05.dao.impl.UserDaoImpl;
import edu.nf.ch05.entity.Users;
import edu.nf.ch05.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/1
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){

    }

    /**
     * 通过构造方法注入
     * @param userdao
     */
    public UserServiceImpl(UserDao userdao){
        this.userDao=userdao;
    }

    private UserDao userDao;

    /**
     * 提供一个set方法给Spring容器，这个方法就是注入的入口方法
     * 那么Spring就会调用这个方法，从容器中将一个UserDao的实现类
     * 给注入进来，赋值给上面的接口
     * @param userDao
     */
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void add(Users user) {
//        //初始化容器
//        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//        //从容器中找到对应的UserDao的实现类对象
//        UserDao dao=context.getBean("userDao",UserDao.class);
//        dao.save(user);
        userDao.save(user);
    }
}
