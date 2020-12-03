package edu.nf.ch09.service.impl;

import edu.nf.ch09.dao.UserDao;
import edu.nf.ch09.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 洒度
 * @date 2020/12/3
 */
//@Component("UserService")
//可以使用@Service注解来标识业务层
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    public void setUserDao(UserDao dao){
//        this.userDao=dao;
//    }

    @Override
    public void add() {
        System.out.println("执行UserServiceImpl");
        userDao.save();
    }
}
