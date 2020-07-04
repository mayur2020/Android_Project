package com.example.scannerapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class display_animal extends AppCompatActivity {

    private EditText id;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animal);

        id = findViewById(R.id.id);
        submit = findViewById((R.id.display));

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String a_id = id.getText().toString();

                String link = "http://" + IPConfig.IP + ":8080/displayanimal.php?";
                try {
                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(a_id, "UTF-8");
                    BackgroundTasker2 tasker = new BackgroundTasker2(display_animal.this);
                    tasker.execute(link, data);
                    String s = tasker.get();
                    display_info1(s);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void display_info1(String s) throws JSONException {
        JSONObject jsonObject = new JSONObject(s);
        try {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                    String info = "\n ID = " + jsonObject.getString("id") +
                                    "\n Gender = " + jsonObject.getString("gender") +
                                    "\n Animal Type = " + jsonObject.getString("animal_type") +
                                    "\n Age = " + jsonObject.getString("age") +
                                    "\n Case_Type = " + jsonObject.getString("case_type") +
                                    "\n Diagnosis = " + jsonObject.getString("diagnosis") +
                                    "\n Vaccination = " + jsonObject.getString("vaccination") +
                                    "\n Doctor = " + jsonObject.getString("doctor");
                    TextView tv = findViewById(R.id.box);
                    tv.setText(info);
                }

        }
        catch (JSONException e) {
            Toast.makeText(this, "Here Is :-" + e, Toast.LENGTH_LONG).show();
        }
    }
}


