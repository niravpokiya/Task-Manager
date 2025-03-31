package com.Spring.TaskManager.Controllers;

import com.Spring.TaskManager.Entities.User;
import com.Spring.TaskManager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> Users() {
        return userService.usersList();
    }
}
