package edu.nf.ch19.demo2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 洒度
 * @date 2020/12/9
 * 自定义监听器
 */
@Component
public class DemoEventlistener {

    /**
     * 监听处理方法
     * @param event
     * @EventListener标注当前方法为一个事件监听处理方法
     */
    @EventListener
    public void handleEvent(DemoEvent event){
        System.out.println("处理消息："+event.getMessage());
    }
}
