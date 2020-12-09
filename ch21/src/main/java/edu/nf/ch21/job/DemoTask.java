package edu.nf.ch21.job;

import edu.nf.ch21.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 洒度
 * @date 2020/12/9
 * 定时任务处理类
 */
@Component
public class DemoTask {

    private TaskService service;

    /**
     * 定时任务需要反复执行TaskService中的业务逻辑，
     * 因此将它注入进来
     * @param service
     */
    @Autowired
    public void setService(TaskService service){
        this.service=service;
    }

    /**
     * 定时备份
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeBackup(){
        service.backup();
    }

    /**
     * 定时清理
     */
    @Scheduled(cron = "0/8 * * * * ?")
    public void executeClean(){
        service.clean();
    }
}
