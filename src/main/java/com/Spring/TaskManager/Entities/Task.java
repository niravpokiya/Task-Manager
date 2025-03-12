package com.Spring.TaskManager.Entities;

import com.Spring.TaskManager.Enums.Status;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "task_seq", sequenceName = "task_sequence", allocationSize = 1)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time")
    private Date updatedTime;

    @OneToOne(mappedBy = "task", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private CompletedTask completedTask;

    @PrePersist
    protected void onCreate() {
        this.createdTime = new Date();
        this.updatedTime = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedTime = new Date();
    }

}
