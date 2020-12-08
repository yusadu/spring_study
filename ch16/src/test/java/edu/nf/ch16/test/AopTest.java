package edu.nf.ch16.test;

import edu.nf.ch16.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/8
 */
public class AopTest {

    @Test
    public void testAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service=context.getBean("userService", UserService.class);
        service.add("user1");
    }
}
