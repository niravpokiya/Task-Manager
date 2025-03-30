package com.Spring.TaskManager.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/")
public class UserController {

    @GetMapping("users")
    public String Users() {
        return "Users List";
    }
}
