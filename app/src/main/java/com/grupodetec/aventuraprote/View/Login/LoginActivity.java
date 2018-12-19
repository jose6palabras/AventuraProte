package com.grupodetec.aventuraprote.View.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.Home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
    }
    public void guestLogin (View view){
        Intent intentguest = new Intent(this, HomeActivity.class);
        startActivity(intentguest);


    }
}
