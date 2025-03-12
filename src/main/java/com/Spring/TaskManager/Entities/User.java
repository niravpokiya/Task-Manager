package com.Spring.TaskManager.Entities;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
}
