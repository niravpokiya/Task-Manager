package com.Spring.TaskManager.Services;

import com.Spring.TaskManager.Entities.CompletedTask;
import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Entities.User;
import com.Spring.TaskManager.Enums.Status;
import com.Spring.TaskManager.Repositories.CompletedTaskRepository;
import com.Spring.TaskManager.Repositories.TaskRepository;
import com.Spring.TaskManager.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository tasks;

    @Autowired
    private CompletedTaskRepository ctasks;

    @Autowired
    private UserRepository userRepository; // Added to get user details

    // ✅ Save tasks with user association
    public Task saveTask(Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found");
        }

        task.setUser(user); // Associate task with the user
        task.setCreatedTime(new Date());
        task.setUpdatedTime(new Date());

        return tasks.save(task);
    }

    // ✅ Update only necessary fields of a task
    @Transactional
    public Task updateTask(int id, Task newtask) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found !");
        }
        Task task = tasks.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        if (task.getUser().getId() != user.getId()) {
            throw new RuntimeException("Unauthorized: You cannot update this task");
        }

        task.setTitle(newtask.getTitle());
        task.setDescription(newtask.getDescription());
        task.setStatus(newtask.getStatus());
        task.setUpdatedTime(new Date());

        return tasks.save(task);
    }

    // ✅ Fetch all tasks for a specific user
    public List<Task> getTasksByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new RuntimeException("User not found");
        }

        return tasks.findByUser(user);
    }

    // ✅ Move a task to completed tasks
    public Task moveToCompletedTasks(int id) {
        Task task_to_move = tasks.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task_to_move.setStatus(Status.COMPLETED);
        CompletedTask completed = new CompletedTask(task_to_move);
        ctasks.save(completed);

        return tasks.save(task_to_move);
    }

    // ✅ Delete a task safely
    @Transactional
    public Task deleteTask(int id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        Task task = tasks.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if(task == null) {
            throw new RuntimeException("Task not found");
        }
        if(user.getId() != task.getUser().getId()) {
            throw new RuntimeException("You cannot delete this task.");
        }
        tasks.delete(task);
        return task;
    }

}
