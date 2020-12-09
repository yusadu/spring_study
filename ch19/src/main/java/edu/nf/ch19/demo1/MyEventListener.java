package edu.nf.ch19.demo1;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 洒度
 * @date 2020/12/9
 * 自定义事件监听器，实现ApplicationListener接口
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    /**
     * 当向容器发布一个事件的时候，会被此监听器监听到，
     * 容器就会调用onApplicationEven方法并传入事件对象
     * @param myEvent
     */
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        Object source=myEvent.getSource();
        //可以从事件对象中获取事件源
        MySource mySource=(MySource)source;
        System.out.println("处理消息："+mySource.getMessage());
    }
}
