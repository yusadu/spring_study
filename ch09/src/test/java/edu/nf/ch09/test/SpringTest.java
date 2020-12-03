package edu.nf.ch09.test;

import edu.nf.ch09.controller.UserController;
import edu.nf.ch09.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/3
 */
public class SpringTest {

    @Test
    public void testSave(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        UserController controller=context.getBean("userController",UserController.class);
        UserController controller1=context.getBean("userController",UserController.class);
        System.out.println(controller);
        System.out.println(controller1);
        controller.add();
        ((ClassPathXmlApplicationContext)context).close();
    }
}

