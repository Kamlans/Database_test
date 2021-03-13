package com.example.databasetest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TaskDB extends RealmObject {
    @PrimaryKey
    private  int taskID;
    private String task;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
