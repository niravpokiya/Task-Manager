package com.Spring.TaskManager.Entities;

import jakarta.persistence.PrePersist;

import java.util.Date;

public class DeletedTask extends Task {
    private Date DeletedDate;
    @PrePersist
    public void OnInsert(){
        this.DeletedDate = new Date();
    }
}
