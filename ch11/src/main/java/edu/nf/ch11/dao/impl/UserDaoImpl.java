package edu.nf.ch11.dao.impl;

import edu.nf.ch11.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author 洒度
 * @date 2020/12/4
 */
@Repository
@Scope("singleton")
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("执行UserDaoImpl的构造方法");
    }

    @Override
    public void add() {
        System.out.println("insert into user_info......");
    }

    @PostConstruct
    public void init(){
        System.out.println("执行UserDaoImpl的init方法");
    }
}
