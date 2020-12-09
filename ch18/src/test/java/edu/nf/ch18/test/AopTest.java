package edu.nf.ch18.test;

import edu.nf.ch18.config.SpringConfig;
import edu.nf.ch18.service.StuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/9
 */
public class AopTest {

    @Test
    public void testAop(){
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        StuService service=context.getBean("stuService",StuService.class);
        service.save("user1");
    }
}
