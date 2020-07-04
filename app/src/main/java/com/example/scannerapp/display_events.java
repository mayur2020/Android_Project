package com.example.scannerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;


public class display_events extends AppCompatActivity {

    private TextView id;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_events);

        id = findViewById(R.id.dispeid);
        submit = findViewById((R.id.disped));

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(patient_registration.this,"Click", Toast.LENGTH_SHORT).show();

                String a_id = id.getText().toString();

                String link = "http://" + IPConfig.IP + ":8080/displayevent.php?";
                try {
                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(a_id, "UTF-8");
                    BackgroundTasker2 tasker = new BackgroundTasker2(display_events.this);
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
                        "\n Event name = " + jsonObject.getString("name") +
                        "\n Description = " + jsonObject.getString("description") +
                        "\n Date = " + jsonObject.getString("date") +
                        "\n Time = " + jsonObject.getString("time") +
                        "\n Venue = " + jsonObject.getString("venue");
                TextView tv = findViewById(R.id.anbox);
                tv.setText(info);
            }

        }
        catch (JSONException e) {
            Toast.makeText(this, "Here Is :-" + e, Toast.LENGTH_LONG).show();
        }
    }

}
