package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_update extends AppCompatActivity {

    Button update_animal;
    Button update_doc;
    Button update_vol;
    Button update_animalsec;
    Button update_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);

            update_animal = (Button) findViewById(R.id.animal);
            update_doc = (Button) findViewById(R.id.addd);
            update_vol = (Button) findViewById(R.id.addv);
            update_animalsec = (Button) findViewById(R.id.animals);
            update_event = (Button) findViewById(R.id.adde);

            update_animal.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(admin_update.this,update_animal.class);
                    admin_update.this.startActivity(intent);
                }
            });

            update_animalsec.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(admin_update.this,update_animalsec.class);
                    admin_update.this.startActivity(intent);
                }
            });

        update_doc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_update.this,update_doctor.class);
                admin_update.this.startActivity(intent);
            }
        });


        }
}
