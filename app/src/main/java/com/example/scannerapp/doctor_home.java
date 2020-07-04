package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class doctor_home extends AppCompatActivity {

    Button home;
    Button logout;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);


        home = findViewById(R.id.dhome);
        logout = (Button) findViewById(R.id.dlogout);
        update = (Button) findViewById(R.id.dupdate);

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_home.this,LoginActivity.class);
                doctor_home.this.startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_home.this,Home.class);
                doctor_home.this.startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_home.this,update_animal.class);
                doctor_home.this.startActivity(intent);
            }
        });

    }
}
