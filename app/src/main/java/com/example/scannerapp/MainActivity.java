package com.example.scannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static TextView result_text;
    Button scan_btn;
    TextView t1;
    //String id,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan_btn = (Button) findViewById(R.id.btn_scan);
        t1=(TextView)findViewById(R.id.result_text);

        result_text = (TextView)findViewById(R.id.result_text);


    }

    public void open(View view) {
        startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class ));
    }
}
