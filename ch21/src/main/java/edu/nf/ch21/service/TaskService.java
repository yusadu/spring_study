package edu.nf.ch21.service;

/**
 * @author 洒度
 * @date 2020/12/9
 * 定时任务处理服务
 */
public interface TaskService {

    /**
     * 定时备份
     */
    void backup();

    /**
     * 定时清理
     */
    void clean();
}
