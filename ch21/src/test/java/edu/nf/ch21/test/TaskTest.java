package edu.nf.ch21.test;

import edu.nf.ch21.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/9
 */
public class TaskTest {

    @Test
    public void testTask(){
        //容器创建后就会立即执行定时任务
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        while (true);
    }
}
