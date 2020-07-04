package com.example.scannerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class delete_animal extends AppCompatActivity {
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_animal);
        e1=(EditText)findViewById(R.id.anime_id);

    }

    public void delete(View view) {

        String a_id = e1.getText().toString();

        String link = "http://" + IPConfig.IP + ":8080/deleteanimal.php?";
        try {
            String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(a_id, "UTF-8");
            BackgroundTasker2 tasker = new BackgroundTasker2(delete_animal.this);
            tasker.execute(link, data);
            String s = tasker.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
