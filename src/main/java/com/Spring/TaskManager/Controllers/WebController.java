package com.Spring.TaskManager.Controllers;

import com.Spring.TaskManager.Entities.Task;
import com.Spring.TaskManager.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private TaskServices taskservices;

    @RequestMapping("/")
    public String Home(Model model) {
        List<Task> tasks = taskservices.GetAllTasks(2);
        model.addAttribute("tasks", tasks);
        return "Home";
    }
}
