package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class MainActivity extends AppCompatActivity {

    private final String AppId ="databasetest-ureag";
    private  App app;
    private AtomicReference<User>  user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext() , MainActivity2.class));
            }
        });

        app = new App(new AppConfiguration.Builder(AppId).build());

        Login();
    }

    private void Login() {
        Credentials emailPasswordCredentials = Credentials.emailPassword(findViewById(R.id.email).toString() , findViewById(R.id.password).toString()  );
         user= new AtomicReference<User>();
        app.loginAsync(emailPasswordCredentials , it ->{
            if (it.isSuccess()){
                Toast.makeText(this, "Successfully authenticated using an email and password.", Toast.LENGTH_SHORT).show();
                user.set(app.currentUser());
            }else {
                Toast.makeText(this, it.getError().toString() , Toast.LENGTH_SHORT).show();
            }
        });


    }

    private  void Logout(){
        user.get().logOutAsync( result -> {

            if (result.isSuccess()){
                Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this , result.getError().toString() , Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (app.currentUser() != null) startActivity(new Intent( MainActivity.this , MainActivity2.class));
    }
}