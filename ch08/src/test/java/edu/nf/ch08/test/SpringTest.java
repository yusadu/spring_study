package edu.nf.ch08.test;

import edu.nf.ch08.dao.UserDao;
import edu.nf.ch08.entity.Users;
import edu.nf.ch08.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 洒度
 * @date 2020/12/2
 */
public class SpringTest {
    @Test
    public void testlistUser(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        UserService userService=context.getBean("userService", UserService.class);
        List<Users> list=userService.listUser();
        list.forEach(users -> System.out.println(users.getUid()+":"+users.getUsername()));
    }
}
