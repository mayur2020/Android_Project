package com.example.scannerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class add_volunteer extends AppCompatActivity {

    EditText vid,vname,vadd,vphno,vemail,vdept,vpastexp,vdob,vqual,vpass;
    Button addvol;
    private RadioButton gen;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_volunteer);


        vid = (EditText) findViewById(R.id.vid);
        vname = (EditText) findViewById(R.id.vname);
        vadd = (EditText) findViewById(R.id.vadd);
        vphno = (EditText) findViewById(R.id.vphno);
        vemail = (EditText) findViewById(R.id.vemail);
        radioGroup=findViewById(R.id.radio);
        vdept = (EditText) findViewById(R.id.vdept);
        vpastexp = (EditText) findViewById(R.id.vpast);
        vdob = (EditText) findViewById(R.id.vdob);
        vqual = (EditText) findViewById(R.id.vqual);
        vpass = (EditText) findViewById(R.id.vpass);
        // addasec = (Button) findViewById(R.id.assave);



        addvol = (Button)findViewById((R.id.vreg));
        addvol.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String v_id = vid.getText().toString();
                String v_name = vname.getText().toString();
                String v_add = vadd.getText().toString();
                String v_phno = vphno.getText().toString();
                String v_email = vemail.getText().toString();
                String v_dept = vdept.getText().toString();
                String v_past = vpastexp.getText().toString();
                String v_dob = vdob.getText().toString();
                String v_qual = vqual.getText().toString();
                String v_pass = vpass.getText().toString();


                int selectedid = radioGroup.getCheckedRadioButtonId();
                gen = findViewById(selectedid);
                if(selectedid==-1) {
                    Toast.makeText(add_volunteer.this, "Nothing selected!", Toast.LENGTH_SHORT).show();
                }
                else{
                        Toast.makeText(add_volunteer.this, gen.getText(), Toast.LENGTH_SHORT).show();
                    }
                    String v_gen = gen.getText().toString();


                    String link = "http://" + IPConfig.IP + ":8080/add_volunteer.php?";
                    try {
                        String data = URLEncoder.encode("vid", "UTF-8") + "=" + URLEncoder.encode(v_id, "UTF-8")
                                + "&&" + URLEncoder.encode("vname", "UTF-8") + "=" + URLEncoder.encode(v_name, "UTF-8") + "&&"
                                + URLEncoder.encode("vadd", "UTF-8") + "=" + URLEncoder.encode(v_add, "UTF-8")
                                + "&&" + URLEncoder.encode("vphno", "UTF-8") + "=" + URLEncoder.encode(v_phno, "UTF-8")
                                + "&&" + URLEncoder.encode("vemail", "UTF-8") + "=" + URLEncoder.encode(v_email, "UTF-8")
                                + "&&" + URLEncoder.encode("vgen", "UTF-8") + "=" + URLEncoder.encode(v_gen, "UTF-8")
                                + "&&" + URLEncoder.encode("vdept", "UTF-8") + "=" + URLEncoder.encode(v_dept, "UTF-8")
                                + "&&" + URLEncoder.encode("vpast", "UTF-8") + "=" + URLEncoder.encode(v_past, "UTF-8")
                                + "&&" + URLEncoder.encode("vdob", "UTF-8") + "=" + URLEncoder.encode(v_dob, "UTF-8")
                                + "&&" + URLEncoder.encode("vqual", "UTF-8") + "=" + URLEncoder.encode(v_qual, "UTF-8")
                                + "&&" + URLEncoder.encode("vpass", "UTF-8") + "=" + URLEncoder.encode(v_pass, "UTF-8");


                        BackgroundTasker2 tasker = new BackgroundTasker2(add_volunteer.this);
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
