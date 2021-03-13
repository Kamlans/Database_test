package com.example.databasetest;

import io.realm.RealmObject;

public class dataModel extends RealmObject {

    public dataModel() {

    }

    private String name;
    private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public dataModel(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}
