package com.example.covid19.model;

import android.media.Image;

import java.net.URL;

public class tweets {

    public String date;
    public String link;
    public String text;
    public String username;


    public tweets(String username,String text, String link,  String date) {
        this.date = date;
        this.link = link;
        this.text = text;
        this.username = username;
    }

    public tweets() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
