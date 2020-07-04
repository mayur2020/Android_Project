package com.example.scannerapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView .ResultHandler {

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {

        Toast.makeText(ScanCodeActivity.this,"value : Scanned successfully",Toast.LENGTH_LONG).show();
        String res=result.getText();

        if(res!=" ")
        {

            String link = "http://" + IPConfig.IP + ":8080/scan_data.php?";
            try {
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(res, "UTF-8");
                BackgroundTasker2 tasker = new BackgroundTasker2(ScanCodeActivity.this);
                tasker.execute(link, data);
                String s = tasker.get();


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
                        MainActivity.result_text.setText(info);
                        onBackPressed();
                    }

                }
                catch (JSONException e) {
                    Toast.makeText(this, "Here Is :-" + e, Toast.LENGTH_LONG).show();
                }


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
    }

    @Override
    protected void onPause(){
        super.onPause();
        scannerView.stopCamera();

    }

    @Override
    protected void onResume(){
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();


    }


}
