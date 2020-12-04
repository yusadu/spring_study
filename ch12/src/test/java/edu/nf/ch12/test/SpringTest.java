package edu.nf.ch12.test;

import edu.nf.ch12.config.SpringConfig;
import edu.nf.ch12.controller.UserController;
import edu.nf.ch12.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/4
 */
public class SpringTest {

    @Test
    public void testConfig(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller=context.getBean("userController",UserController.class);
        controller.save();
    }
}
