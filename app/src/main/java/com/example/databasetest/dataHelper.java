package com.example.databasetest;

import io.realm.Realm;

public class dataHelper {

    public static void newTask(Realm realm , int taskID , String task){
        realm.beginTransaction();

        TaskDB taskDB = realm.createObject(TaskDB.class ,taskID);
        taskDB.setTask(task);
        realm.commitTransaction();
    }

    public static void deleteTask( Realm realm , final long id){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TaskDB taskDBitem = realm.where(TaskDB.class).equalTo("id", id).findFirstAsync();

                if(taskDBitem != null) taskDBitem.deleteFromRealm();
            }
        });
    }
}
