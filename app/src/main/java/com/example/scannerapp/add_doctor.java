package com.example.scannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class add_doctor extends AppCompatActivity {

    private EditText name,add,ph,email,dept,city,dob,pass;
    private Button register;
    private RadioButton gen;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        name = findViewById(R.id.dname);
        add = findViewById(R.id.dadd);
        ph = findViewById(R.id.dphno);
        email = findViewById(R.id.demail);
        dept = findViewById(R.id.ddept);
        city= findViewById(R.id.dcity);
        dob = findViewById(R.id.ddob);
        pass= findViewById(R.id.dpass);
        radioGroup=findViewById(R.id.dradio);

        register = (Button)findViewById((R.id.register));
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String d_name = name.getText().toString();
                String d_add = add.getText().toString();
                String d_ph = ph.getText().toString();
                String d_email = email.getText().toString();
                String d_dept = dept.getText().toString();
                String d_city = city.getText().toString();
                String d_dob = dob.getText().toString();
                String d_pass = pass.getText().toString();

                int selectedid = radioGroup.getCheckedRadioButtonId();
                gen = findViewById(selectedid);
                if(selectedid==-1)
                {
                    Toast.makeText(add_doctor.this,"Nothing selected.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(add_doctor.this,gen.getText(),Toast.LENGTH_SHORT).show();
                }
                String d_gender = gen.getText().toString();

                String link = "http://"+IPConfig.IP+":8080/adddoctor.php?";
                try {
                    String data = URLEncoder.encode("dname", "UTF-8") + "=" + URLEncoder.encode(d_name, "UTF-8")
                            + "&&" + URLEncoder.encode("dadd", "UTF-8") + "=" + URLEncoder.encode(d_add, "UTF-8")
                            + "&&" + URLEncoder.encode("ph", "UTF-8") + "=" + URLEncoder.encode(d_ph, "UTF-8")
                            + "&&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(d_email, "UTF-8")
                            + "&&" + URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(d_gender, "UTF-8")
                            + "&&" + URLEncoder.encode("dept", "UTF-8") + "=" + URLEncoder.encode(d_dept, "UTF-8")
                            + "&&" + URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(d_city, "UTF-8")
                            + "&&" + URLEncoder.encode("dob", "UTF-8") + "=" + URLEncoder.encode(d_dob, "UTF-8")
                            + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(d_pass, "UTF-8");

                    BackgroundTasker2 tasker = new BackgroundTasker2(add_doctor.this);
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
