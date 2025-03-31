package com.Spring.TaskManager.Controllers;

import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private TaskServices taskservices;

    @RequestMapping("/")
    public String Home(Model model) {
        List<Task> tasks = taskservices.getTasksByUser();
        model.addAttribute("tasks", tasks);
        return "Home";
    }
//    @GetMapping("/update-task/{id}")
//    public String updateTask(@PathVariable int id, Model model) {
//        Task task = taskservices.getById(id);
//        model.addAttribute("task", task);
//        return "update-task";
//    }
//    @PostMapping("/updateTask")
//    public String updateTask(@ModelAttribute Task task) {
//        taskservices.updateTask(task); // Save updates
//        return "redirect:/"; // Redirect to task list
//    }
//    @RequestMapping("/add-task")
//    public String addTask() {
//        return "add-task";
//    }
//    @PostMapping("/addTask")
//    public String addTask(@ModelAttribute Task task) {
//        taskservices.saveTask(task);
//        return "redirect:/";
//    }
}
