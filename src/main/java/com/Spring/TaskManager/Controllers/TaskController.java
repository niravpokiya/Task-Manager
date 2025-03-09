package com.Spring.TaskManager.Controllers;

import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TaskController {

    @Autowired
    TaskServices taskServices;

    @GetMapping("/get/{userid}")
    public List<Task> getTask(@PathVariable int userid) {
        return taskServices.GetAllTasks(userid);
    }

    @PostMapping("/post")
    public Task PostTask(@RequestBody Task task) {
        return taskServices.createTask(task);
    }

    @PutMapping("/update/{id}")
    public Task UpdateTask(@PathVariable int id, @RequestBody Task task) {
        return taskServices.UpdateTask(id, task);
    }

    @DeleteMapping("/delete/{id}")
    public Task DeleteTask(@PathVariable int id) {
        return taskServices.DeleteTask(id);
    }
}