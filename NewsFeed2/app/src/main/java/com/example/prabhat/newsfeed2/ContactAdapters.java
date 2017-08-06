package com.example.prabhat.newsfeed2;

/**
 * Created by prabhat on 06-08-2017.
 */
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ContactAdapters extends ArrayAdapter {
    List list=new ArrayList();
    Context context;
    public ContactAdapters( Context context, int resource) {
        super(context, resource);
        this.context=context;
    }

    public void add(Contacts object){
        super.add(object);
        list.add(object);

    }

    public int getCount(){
        return list.size();
    }

    public Object getItem(int position){
        return list.get(position); //deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ContactHolder ch;
        View row;
        row=convertView;
        if(row==null){
            LayoutInflater lf=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=lf.inflate(R.layout.row,parent,false);
            ch=new ContactHolder();
            ch.headline=(TextView)row.findViewById(R.id.headline);
            ch.rname=(TextView)row.findViewById(R.id.rname);
            ch.date=(TextView)row.findViewById(R.id.date);
            ch.image=(ImageView)row.findViewById(R.id.image);
            ch.content=(TextView)row.findViewById(R.id.content);
            row.setTag(ch);
        }
        else{
            ch=(ContactHolder)row.getTag();
        }
        Contacts c=(Contacts)this.getItem(position);

        ch.headline.setText(c.getHeadline());
        ch.rname.setText(c.getRname());
        ch.date.setText(c.getDate());
        Picasso.with(context).load(c.getImage()).into(ch.image);
        ch.content.setText(c.getContent());
        return row;
    }

    static class ContactHolder{
        TextView headline,rname,date,content;
        ImageView image;
    }

}





