package com.example.databasetest;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.mongodb.Credentials;

public class MyApplication extends Application {

    private Realm uiThreadRealm;
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        String realmName = "My project";
        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();
        uiThreadRealm = Realm.getInstance(config);

        //insert
        uiThreadRealm.beginTransaction();
        dataModel user2 = uiThreadRealm.createObject(dataModel.class);
        dataModel user1 = uiThreadRealm.createObject(dataModel.class);

        user1.setName("jullu");
        user1.setRoll(21);
        uiThreadRealm.insert(user1);

        user2.setName("kamlans");
        user2.setRoll(21);
        uiThreadRealm.insert(user2);

        uiThreadRealm.commitTransaction();


        //query
        RealmQuery<dataModel> userquery = uiThreadRealm.where(dataModel.class);

        //query execution
        RealmResults<dataModel> results = userquery.findAllAsync();


       
    }
}
