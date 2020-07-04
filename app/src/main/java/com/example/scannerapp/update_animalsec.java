package com.example.scannerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class update_animalsec extends AppCompatActivity {

    EditText u_id;
    EditText u_value;
    Button update;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_animalsec);

        u_id = (EditText) findViewById(R.id.uid);
        u_value = (EditText) findViewById(R.id.uval);
        update = (Button)findViewById((R.id.update));
        update.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                String uid = u_id.getText().toString();
                String uvalue = u_value.getText().toString();
                spinner = (Spinner) findViewById((R.id.spin));
                String col = spinner.getSelectedItem().toString();
                //Toast.makeText(update_animalsec.this,col, Toast.LENGTH_SHORT).show();


                String link = "http://"+IPConfig.IP+":8080/update_animalsec.php?";
                try {
                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(uid, "UTF-8")
                            + "&&" + URLEncoder.encode("col", "UTF-8") + "=" + URLEncoder.encode(col, "UTF-8")
                            + "&&" + URLEncoder.encode("value", "UTF-8") + "=" + URLEncoder.encode(uvalue, "UTF-8");

                    BackgroundTasker2 tasker = new BackgroundTasker2(update_animalsec.this);
                    tasker.execute(link, data);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
