package com.example.scannerapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button log;
    TextView mTextViewRegister;
    DatabaseHelper db;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        Toast.makeText(this,"Till here ok",Toast.LENGTH_SHORT);
       // View v = this.getLayoutInflater().inflate(R.layout.progressbar, null);
      //  dialog.setContentView(v);
       // dialog.show();

        db = new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.edittext_username);
        password = (EditText) findViewById(R.id.edittext_password);
        log = (Button) findViewById(R.id.button_login);


        log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LoginActivity.this,"Login..", Toast.LENGTH_SHORT).show();

                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    String link = "http://"+IPConfig.IP+":8080/doclog.php?";
                    try {
                        String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                                + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                        Intent intent1 = new Intent(LoginActivity.this, doctor_home.class);
                        Intent intent2 = new Intent(LoginActivity.this, vol_home.class);
                        Intent intent3 = new Intent(LoginActivity.this, admin_home.class);
                        BackgroundTasker tasker = new BackgroundTasker(LoginActivity.this, intent1, intent2, intent3);
                        tasker.execute(link, data);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
            }
        });

    }

    public void showProgressingView() {

        if (!isProgressShowing) {
            View view=findViewById(R.id.progressBar1);
            view.bringToFront();
        }
    }

    public void hideProgressingView() {
        View v = this.findViewById(android.R.id.content).getRootView();
        ViewGroup viewGroup = (ViewGroup) v;
        viewGroup.removeView(progressView);
        isProgressShowing = false;
    }

    public void log_in(View view) {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
}