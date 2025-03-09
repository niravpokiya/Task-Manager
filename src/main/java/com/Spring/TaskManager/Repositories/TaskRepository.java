package com.Spring.TaskManager.Repositories;

import com.Spring.TaskManager.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;
@RestController
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(int userId);
}
