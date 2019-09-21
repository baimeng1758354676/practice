package com.bm.task.center.service.impl;

import cn.hutool.http.HttpRequest;
import com.bm.task.center.dao.TaskDao;
import com.bm.task.center.domain.bo.Task;
import com.bm.task.center.service.TaskService;
import com.bm.task.center.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private static Queue<Task> taskQueue = new PriorityBlockingQueue<>(Constant.QUEUE_INITIAL_CAPACITY, new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return (int) (o2.getExecuteTime().getTime() - o1.getExecuteTime().getTime());
        }
    });



    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    TaskDao taskDao;

    @Override
    public Task save(Task task) {

        //对新增的任务进行判断，如果在未来一段时间内将被执行，则放入有序任务队列
//        if (task.getExecuteTime().before()) {
//
//        }
        taskQueue.add(task);
        return taskDao.save(task);
    }

    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void findTaskQueue() {
        //查询近期要处理的任务集合
        List<Task> tasks = taskDao.findTaskQueue(new Date(System.currentTimeMillis() + Constant.TASK_TIME_LIMITED_IN_MILLIS), Constant.TASK_STATUS_NOT_PUT);
        //放入任务队列
        tasks.parallelStream().forEach(task -> {
            if (!taskQueue.contains(task)) {
                if (taskQueue.add(task)) {
                    //成功放入内存，修改状态为   已放入
                    task.setStatus(Constant.TASK_STATUS_PUT);
                    taskDao.save(task);
                }
            }
        });
    }

    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeTask() {
        List<Task> collect = taskQueue.parallelStream()
                .filter(task -> new Date().after(task.getExecuteTime()))
                .collect(Collectors.toList());
        lock.lock();
        taskQueue.removeAll(collect);
        lock.unlock();
        collect.parallelStream().forEach(task -> {
            Date now = new Date();
            if (now.after(task.getExecuteTime())) {
                HttpRequest request = null;
                //创建请求对象
                if (task.getMethod().toUpperCase().equals(Constant.METHOD_GET)) {
                    request = HttpRequest.get(task.getUrl());
                }
                if (task.getMethod().toUpperCase().equals(Constant.METHOD_POST)) {
                    request = HttpRequest.post(task.getUrl()).body(task.getData());
                }
                //执行请求
                if (executeRequest(request)) {
                    //执行成功
                    task.setStatus(Constant.TASK_STATUS_EXECUTED_SUCCESS);
                } else {
                    //执行失败
                    task.setStatus(Constant.TASK_STATUS_EXECUTED_FAILED);
                }
                //从队列中移除
                taskQueue.remove(task);
                //更新数据库的任务状态（成功/失败）
                taskDao.save(task);
            }
        });
    }

    private boolean executeRequest(HttpRequest request) {
        boolean flag = true;
        int count = 0;
        while (flag) {
            if (request.execute().getStatus() == Constant.STATUS_SUCCESS) {
                System.out.println(111);
                return true;
            }
            count++;
            if (count >= Constant.REQUEST_TIME) {
                break;
            }
        }
        return false;
    }
}
