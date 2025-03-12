package com.Spring.TaskManager.Repositories;

import com.Spring.TaskManager.Entities.CompletedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedTaskRepository extends JpaRepository<CompletedTask, Integer> {

}
