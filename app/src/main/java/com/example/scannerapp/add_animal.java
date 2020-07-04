package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import android.view.View;

public class add_animal extends AppCompatActivity {

    private EditText aid,agen,atype,aage,acase,adiagnosis,avac,adoc;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        aid = findViewById(R.id.animalid);
        agen = findViewById(R.id.gender);
        atype = findViewById(R.id.animaltype);
        aage= findViewById(R.id.agegroup);
        acase= findViewById(R.id.casetype);
        adiagnosis= findViewById(R.id.diagnosis);
        avac= findViewById(R.id.vaccination);
        adoc= findViewById(R.id.doctor);

        submit = (Button)findViewById((R.id.add));
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String a_id = aid.getText().toString();
                String a_gen = agen.getText().toString();
                String a_type = atype.getText().toString();
                String a_age = aage.getText().toString();
                String a_case = acase.getText().toString();
                String a_diag = adiagnosis.getText().toString();
                String a_vac = avac.getText().toString();
                String a_doc = adoc.getText().toString();

                String link = "http://"+IPConfig.IP+":8080/addanimal.php?";
                try {
                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(a_id, "UTF-8")
                            + "&&" + URLEncoder.encode("gen", "UTF-8") + "=" + URLEncoder.encode(a_gen, "UTF-8")+ "&&"
                            + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(a_type, "UTF-8")
                            + "&&" + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(a_age, "UTF-8")
                            + "&&" + URLEncoder.encode("case", "UTF-8") + "=" + URLEncoder.encode(a_case, "UTF-8")
                            + "&&" + URLEncoder.encode("diag", "UTF-8") + "=" + URLEncoder.encode(a_diag, "UTF-8")
                            + "&&" + URLEncoder.encode("vac", "UTF-8") + "=" + URLEncoder.encode(a_vac, "UTF-8")
                            + "&&" + URLEncoder.encode("doc", "UTF-8") + "=" + URLEncoder.encode(a_doc, "UTF-8");

                    BackgroundTasker2 tasker = new BackgroundTasker2(add_animal.this);
                    tasker.execute(link, data);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                //startActivity(intent);*/
            }
        });




    }
}
