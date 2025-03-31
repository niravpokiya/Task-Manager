package com.Spring.TaskManager.Controllers;

import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Entities.User;
import com.Spring.TaskManager.Services.TaskServices;
import com.Spring.TaskManager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/user")
public class TaskController{

    @Autowired
    TaskServices taskServices;
    @Autowired
    UserService userService;

    @PostMapping("/create-task")
    public Task PostTask(@RequestBody Task task) {
        return taskServices.saveTask(task);
    }

    @PutMapping("/update-task/{id}")
    public Task UpdateTask(@PathVariable int id, @RequestBody Task task) {
        return taskServices.updateTask(id, task);
    }

    @DeleteMapping("/delete-task/{id}")
    public Task DeleteTask(@PathVariable int id) {
        return taskServices.deleteTask(id);
    }

//    @PostMapping("/task-completed/{id}")
//    public Task taskCompleted(@PathVariable int id) {
//        return taskServices.moveToCompletedTasks(id);
//    }

    @GetMapping("/tasks")
    public List<Task> getUserTasks() {
        return taskServices.getTasksByUser();
    }
}