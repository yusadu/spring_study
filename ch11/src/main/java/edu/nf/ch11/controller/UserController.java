package edu.nf.ch11.controller;

import edu.nf.ch11.service.UserService;
import edu.nf.ch11.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 洒度
 * @date 2020/12/4
 */
@Controller("userController")
public class UserController {
    @Autowired
    private UserService service;

    public void add(){
        service.add();
    }
}
