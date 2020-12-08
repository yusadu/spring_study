package edu.nf.ch16.service.impl;

import edu.nf.ch16.service.UserService;

/**
 * @author 洒度
 * @date 2020/12/8
 */
public class UserServiceImpl implements UserService {
    @Override
    public String  add(String name) {
        System.out.println("添加用户信息"+name);
        return "success";
    }

    @Override
    public void update() {
        System.out.println("修改用户信息");
    }
}
