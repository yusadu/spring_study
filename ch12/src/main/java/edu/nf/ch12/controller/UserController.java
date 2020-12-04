package edu.nf.ch12.controller;

import edu.nf.ch12.service.UserService;

/**
 * @author 洒度
 * @date 2020/12/4
 */

public class UserController {


    private UserService userService;

    public void setUserService(UserService userService){
        this.userService=userService;
    }

    public void save(){
        userService.save();
    }
}
