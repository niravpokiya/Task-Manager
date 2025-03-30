package com.Spring.TaskManager.Services;
import com.Spring.TaskManager.Entities.CompletedTask;
import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Enums.Status;
import com.Spring.TaskManager.Repositories.CompletedTaskRepository;
import com.Spring.TaskManager.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository tasks;
    @Autowired
    private CompletedTaskRepository ctasks;

    public List<Task> createAllTask(List<Task> task) {
        return tasks.saveAll(task);
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

    public Task moveToCompletedTasks(int id) {
        Task task_to_move = tasks.findById(id).orElse(null);
        if (task_to_move == null) {
            throw new RuntimeException("Task not found!");
        }
        task_to_move.setStatus(Status.COMPLETED);
        CompletedTask completed = new CompletedTask(task_to_move);

        try {
            ctasks.save(completed);
        }
        catch (Exception e) {
            System.out.println("Exception Occured  ------------------------");
            System.out.println(e.getMessage());
        }
        return task_to_move;
    }
    public Task getById(int id) {
        return tasks.findById(id).orElse(null);
    }
    public Task updateTask(Task task) {
        Task existingTask = tasks.findById(task.getId()).orElse(null);

        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            existingTask.setUpdatedTime(new Date());

            tasks.save(existingTask); // Save updated task
        }

        return task;
    }
    public Task saveTask(Task task) {
        Task newtask = new Task();
        newtask.setTitle(task.getTitle());
        newtask.setDescription(task.getDescription());
        newtask.setStatus(task.getStatus());
        newtask.setUserId(3);

        tasks.save(newtask);
        return newtask;
    }
    public List<Task> getTaskByUserId(int user_id) {
        return tasks.findByUserId(user_id);
    }
}
