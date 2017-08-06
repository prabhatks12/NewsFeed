package com.example.prabhat.newsfeed2;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListVIew extends AppCompatActivity {

    ContactAdapters contactAdapters;
    ListView listView;
    String json_String;
    JSONObject jsonObject;
    JSONArray jsonArray=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_list_view);
        listView=(ListView)findViewById(R.id.listview);
        contactAdapters=new ContactAdapters(this,R.layout.row); // this line should come before the line given below ,otherwise eerror
        listView.setAdapter(contactAdapters);
        json_String=getIntent().getExtras().getString("json_data");
        try{
            jsonObject=new JSONObject(json_String);    // this line should come before the line given below ,otherwise eerror
            jsonArray=jsonObject.getJSONArray("server");
            int count=0; String headline,rname,date,image,content;
            while(count<jsonArray.length())
            {
                JSONObject jo=jsonArray.getJSONObject(count);

                headline=jo.getString("headline");
                rname=jo.getString("rname");
                date=jo.getString("date");
                image=jo.getString("image");
                content=jo.getString("content");


                Contacts contacts=new Contacts(headline,rname,date,image,content);
                contactAdapters.add(contacts);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
