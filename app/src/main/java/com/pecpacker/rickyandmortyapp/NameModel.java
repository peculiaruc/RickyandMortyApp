package com.pecpacker.rickyandmortyapp;

import com.google.gson.annotations.SerializedName;

public class NameModel {
    @SerializedName("name")
    String name;

    @SerializedName("url")
    String fullurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullurl() {
        return fullurl;
    }

    public void setFullurl(String fullurl) {
        this.fullurl = fullurl;
    }
}
