package edu.nf.ch21.service.impl;

import edu.nf.ch21.service.TaskService;
import org.springframework.stereotype.Service;

/**
 * @author 洒度
 * @date 2020/12/9
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Override
    public void backup() {
        System.out.println(Thread.currentThread().getName()+"执行备份...");
    }

    @Override
    public void clean() {
        System.out.println(Thread.currentThread().getName()+"执行清理...");
    }
}
