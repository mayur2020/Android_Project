package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_home extends AppCompatActivity {

    Button ahome;
    Button alogout;
    Button aupdate;
    Button aadd;
    Button adelete;
    Button adisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        ahome = (Button) findViewById(R.id.home);
        alogout = (Button) findViewById(R.id.logout);
        aupdate = (Button) findViewById(R.id.update);
        aadd = (Button) findViewById(R.id.add);
        adelete = (Button) findViewById(R.id.delete);
        adisplay = (Button) findViewById(R.id.display);

        alogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,LoginActivity.class);
                admin_home.this.startActivity(intent);
            }
        });

        ahome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,Home.class);
                admin_home.this.startActivity(intent);
            }
        });

        aadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,admin_add.class);
                admin_home.this.startActivity(intent);
            }
        });

        aupdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,admin_update.class);
                admin_home.this.startActivity(intent);
            }
        });

        adisplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,admin_display.class);
                admin_home.this.startActivity(intent);
            }
        });


    }

    public void delete(View view) {
        Intent i=new Intent(admin_home.this,delete_animal.class);
        startActivity(i);
    }
}
