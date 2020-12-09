package edu.nf.ch19.test;

import edu.nf.ch19.demo1.MyEvent;
import edu.nf.ch19.demo1.MySource;
import edu.nf.ch19.demo2.DemoEvent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 洒度
 * @date 2020/12/9
 */
public class EvenTest {

    @Test
    public void testEvent(){
        ApplicationContext context=new AnnotationConfigApplicationContext("edu.nf.ch19.demo1");
        //创建事件源
        MySource source=new MySource("Hello spring");
        //事件对象
        MyEvent event =new MyEvent(source);
        //向容器发布事件
        context.publishEvent(event);

    }

    @Test
    public void testEvet2(){
        ApplicationContext context=new AnnotationConfigApplicationContext("edu.nf.ch19.demo2");
        DemoEvent event=new DemoEvent("hello spring");
        context.publishEvent(event);
    }
}
