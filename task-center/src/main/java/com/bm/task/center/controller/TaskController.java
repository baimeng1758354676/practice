package com.bm.task.center.controller;

import com.bm.task.center.domain.bo.Task;
import com.bm.task.center.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping(value = "/save")
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }
}
