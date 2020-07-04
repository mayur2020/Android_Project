package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_add extends AppCompatActivity {

    Button addanimal;
    Button adddoc;
    Button addvol;
    Button addanimalsec;
    Button addevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add);

        addanimal = (Button) findViewById(R.id.animal);
        adddoc = (Button) findViewById(R.id.doc);
        addvol = (Button) findViewById(R.id.vol);
        addanimalsec = (Button) findViewById(R.id.animalsec);
        addevent = (Button) findViewById(R.id.event);

        addanimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this,add_animal.class);
                admin_add.this.startActivity(intent);
            }
        });

        adddoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this, add_doctor.class);
                admin_add.this.startActivity(intent);
            }

        });

        addevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this, add_events.class);
                admin_add.this.startActivity(intent);
            }

        });


        addvol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this, add_volunteer.class);
                admin_add.this.startActivity(intent);
            }

        });

        addanimalsec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this, add_animalsection.class);
                admin_add.this.startActivity(intent);
            }

        });

        addevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_add.this, add_events.class);
                admin_add.this.startActivity(intent);
            }

        });

    }
}



