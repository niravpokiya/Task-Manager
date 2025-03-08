package com.Spring.TaskManager.Entities;
import com.Spring.TaskManager.Enums.Status;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private Date CreatedDate;
    private Date UpdatedDate;
}
