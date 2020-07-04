package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class vol_home extends AppCompatActivity {

    Button home;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vol_home);

        home = findViewById(R.id.vhome);
        logout = (Button) findViewById(R.id.vlogout);

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vol_home.this,LoginActivity.class);
                vol_home.this.startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vol_home.this,Home.class);
                vol_home.this.startActivity(intent);
            }
        });

    }
}
