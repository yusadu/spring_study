package edu.nf.ch08.service;

import edu.nf.ch08.dao.UserDao;
import edu.nf.ch08.entity.Users;

import java.util.List;

/**
 * @author 洒度
 * @date 2020/12/2
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    /**
     * 通过set方法注入UserDao的实现类
     * 注意：此时注入的就是mapperProxy代理对象
     * @param userDao
     */
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public List<Users> listUser() {
        return userDao.listUser();
    }
}
