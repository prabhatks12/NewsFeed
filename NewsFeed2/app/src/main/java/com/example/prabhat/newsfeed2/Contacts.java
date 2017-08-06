package com.example.prabhat.newsfeed2;

/**
 * Created by prabhat on 06-08-2017.
 */

public class Contacts {
    private String headline,rname,date,image,content;

    public Contacts(String headline, String rname, String date, String image, String content) {
        this.headline = headline;
        this.rname = rname;
        this.date = date;
        this.image = image;
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
