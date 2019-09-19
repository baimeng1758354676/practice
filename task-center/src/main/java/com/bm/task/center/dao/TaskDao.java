package com.bm.task.center.dao;

import com.bm.task.center.domain.bo.Task;

import java.util.Date;
import java.util.List;

public interface TaskDao {

    /**
     * 新增/更新任务
     *
     * @param task
     * @return
     */
    Task save(Task task);


    Task findById(Integer id);

    /**
     * 查询要存在内存中的任务集合
     *
     * @param date
     * @param status
     * @return
     */
    List<Task> findTaskQueue(Date date, Integer status);

}
