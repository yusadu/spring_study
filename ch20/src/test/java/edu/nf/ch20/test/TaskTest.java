package edu.nf.ch20.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/9
 */
public class TaskTest {

    @Test
    public void testTask(){
        //容器创建后就会立即执行定时任务
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        while (true);
    }
}
