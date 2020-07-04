package com.example.scannerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundTasker extends AsyncTask<String,Void,String> {

    private Intent intent = null;
    private Intent intent1 = null;
    private Intent intent2 = null;
    private Intent intent3 = null;
    private Context context;

    public BackgroundTasker(Context context){
        this.context = context;
    }

    public BackgroundTasker(Context context, Intent intent){
        this.context = context;
        this.intent = intent;
    }

    public BackgroundTasker(Context context, Intent intent1, Intent intent2, Intent intent3){
        this.context = context;
        this.intent1 = intent1;
        this.intent2 = intent2;
        this.intent3 = intent3;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s.equalsIgnoreCase("doctor")){
            if(intent1!=null){
                context.startActivity(intent1);
            }
        }
        else if(s.equalsIgnoreCase("vol")) {
            if(intent2!=null){
                context.startActivity(intent2);
            }
        }
        else if(s.equalsIgnoreCase("RESULT_OK")){
            if(intent1!=null){
                context.startActivity(intent);
            }
        }
        else if(s.equalsIgnoreCase("admin")){
            if(intent3!=null){
                context.startActivity(intent3);
            }
        }
    }

    @Override
    protected String doInBackground(String... strings) {

        String result = "";
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            writer.write(strings[1]);
            writer.flush();
            writer.close();
            ops.close();
            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            System.out.print(result);
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }
        System.out.print(result);

        return null;
    }
}

