package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_display extends AppCompatActivity {

    Button displayanimal;
    Button displaydoc;
    Button displayvol;
    Button displayanimalsec;
    Button displayevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_display);

        displayanimal = (Button) findViewById(R.id.animal);
        displaydoc = (Button) findViewById(R.id.doc);
        displayvol = (Button) findViewById(R.id.vol);
        displayanimalsec = (Button) findViewById(R.id.animalsec);
        displayevent = (Button) findViewById(R.id.event);

        displayanimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_display.this,display_animal.class);
                admin_display.this.startActivity(intent);
            }
        });

        displayanimalsec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_display.this,display_animalsec.class);
                admin_display.this.startActivity(intent);
            }
        });

        displayvol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_display.this,display_volunteer.class);
                admin_display.this.startActivity(intent);
            }
        });

        displayevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_display.this,display_events.class);
                admin_display.this.startActivity(intent);
            }
        });

    }
}
