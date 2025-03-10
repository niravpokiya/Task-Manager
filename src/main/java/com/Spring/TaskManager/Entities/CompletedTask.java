package com.Spring.TaskManager.Entities;

import jakarta.persistence.PrePersist;

import java.util.Date;

public class CompletedTask extends Task{
    private Date CompletedDate;
    @PrePersist
    public void OnInsert(){
        this.CompletedDate = new Date();
    }
}
