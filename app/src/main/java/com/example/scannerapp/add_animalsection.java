package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class add_animalsection extends AppCompatActivity {

    EditText secid, secname, noa, nov, secdoc, seccare;
    Button addasec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animalsection);


        secid = (EditText) findViewById(R.id.aid);
        secname = (EditText) findViewById(R.id.asname);
        noa = (EditText) findViewById(R.id.asno);
        nov = (EditText) findViewById(R.id.asvno);
        secdoc = (EditText) findViewById(R.id.asdoc);
        seccare = (EditText) findViewById(R.id.ascno);
        // addasec = (Button) findViewById(R.id.assave);


        addasec = (Button) findViewById((R.id.assave));
        addasec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String a_id = secid.getText().toString();
                String as_name = secname.getText().toString();
                String a_noa = noa.getText().toString();
                String a_nov = nov.getText().toString();
                String as_doc = secdoc.getText().toString();
                String as_care = seccare.getText().toString();

                String link = "http://" + IPConfig.IP + ":8080/add_animalsec.php?";
                try {
                    String data = URLEncoder.encode("aid", "UTF-8") + "=" + URLEncoder.encode(a_id, "UTF-8")
                            + "&&" + URLEncoder.encode("asname", "UTF-8") + "=" + URLEncoder.encode(as_name, "UTF-8") + "&&"
                            + URLEncoder.encode("asnoa", "UTF-8") + "=" + URLEncoder.encode(a_noa, "UTF-8")
                            + "&&" + URLEncoder.encode("asnov", "UTF-8") + "=" + URLEncoder.encode(a_nov, "UTF-8")
                            + "&&" + URLEncoder.encode("asdoc", "UTF-8") + "=" + URLEncoder.encode(as_doc, "UTF-8")
                            + "&&" + URLEncoder.encode("ascare", "UTF-8") + "=" + URLEncoder.encode(as_care, "UTF-8");


                    BackgroundTasker2 tasker = new BackgroundTasker2(add_animalsection.this);
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