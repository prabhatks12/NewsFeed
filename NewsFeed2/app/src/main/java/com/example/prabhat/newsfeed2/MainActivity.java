package com.example.prabhat.newsfeed2;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String JsonString;
    String json_string;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            new Background().execute();

        }
        else {
            Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            Toast.makeText(MainActivity.this,"Turn on WiFi or Mobile Data",Toast.LENGTH_LONG).show();
            startActivity(i);
        }

    }


    class Background extends AsyncTask<Void,Void,String>{

        String json_url;


        protected void onPreExecute(){
            json_url="https://webtechie.000webhostapp.com/Prabhatwork/trythis.txt";
        }



        @Override
        protected String doInBackground(Void... params) {

            try{
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while((JsonString=bufferedReader.readLine())!=null){


                    stringBuilder.append(JsonString+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;

        }


        protected void onPostExecute(String result){
            json_string=result;
            Intent in=new Intent(MainActivity.this,DisplayListVIew.class);
            in.putExtra("json_data",json_string);
            startActivity(in);

        }



    }//class ends here


}

