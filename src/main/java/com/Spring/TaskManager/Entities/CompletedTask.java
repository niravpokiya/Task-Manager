package com.Spring.TaskManager.Entities;

import com.Spring.TaskManager.Enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
public class CompletedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Separate ID for CompletedTask
    private Long id;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id", unique = true)
    private Task task;

    @Column(nullable = false)
    private Date completedDate;

    public CompletedTask(Task task) {
        this.task = task;
        this.completedDate = new Date();
    }
}

