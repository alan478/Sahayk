package com.example.covid19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covid19.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class register extends AppCompatActivity {

    EditText username,password,confirm_password,name;



    public void createmyaccount(View view)
    {
        ParseUser parseUser=new ParseUser();
        parseUser.setUsername(username.getText().toString().trim());
        parseUser.setPassword(password.getText().toString().trim());
        parseUser.put("name",name.getText().toString().trim());
        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                {
                    Toast.makeText(getApplicationContext(),"You're Registered",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        confirm_password=findViewById(R.id.confirm_password);
        name=findViewById(R.id.name);


    }
}
