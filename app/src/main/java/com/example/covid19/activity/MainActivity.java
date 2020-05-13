package com.example.covid19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covid19.R;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    EditText username,password;

    public void registerS(View view)
    {
        Intent intent =new Intent(MainActivity.this, register.class);
        startActivity(intent);

    }
    public void signin(View view)
    {
       ParseUser.logInInBackground(username.getText().toString().trim(), password.getText().toString().trim(), new LogInCallback() {
           @Override
           public void done(ParseUser user, ParseException e) {

               if(user!=null)
               {
                   Toast.makeText(MainActivity.this,"SIGNED IN",Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(MainActivity.this, mainone.class);
                   startActivity(intent);
               }
               else {

               }

           }
       });



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);









        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
