package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button scanner;
    Button animalsec;
    Button vol;
    Button events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        scanner = findViewById(R.id.animal);
        animalsec = (Button) findViewById(R.id.animals);
        vol = (Button) findViewById(R.id.addv);
        events = (Button) findViewById(R.id.adde);

        scanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                Home.this.startActivity(intent);
            }
        });

        animalsec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,display_animalsec.class);
                Home.this.startActivity(intent);
            }
        });

        vol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,display_volunteer.class);
                Home.this.startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,display_events.class);
                Home.this.startActivity(intent);
            }
        });

    }

}
