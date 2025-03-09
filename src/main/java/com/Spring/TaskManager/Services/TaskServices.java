package com.Spring.TaskManager.Services;

import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Enums.Status;
import com.Spring.TaskManager.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository tasks;

    public Task createTask(Task task) {
        return tasks.save(task);
    }

    public Task UpdateTask(int id, Task task) {
        task.setId(id);
        tasks.save(task);
        return task;
    }

    public Task DeleteTask(int id) {
        Task task_to_delete = tasks.findById(id).orElse(null);
        tasks.deleteById(id);
        return task_to_delete;
    }

    public List<Task> GetAllTasks(int user_id) {
        return tasks.findByUserId(user_id);
    }
}
