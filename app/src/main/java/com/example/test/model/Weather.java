package com.example.test.model;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("coord")
    private Location coord;

    @SerializedName("weather")
    private WeatherDesc weather;

    @SerializedName("base")
    private String base;
    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }

    @SerializedName("main")
    private Main main;

    @SerializedName("visibility")
    private int visibility;
    public int getVisibility() {
        return visibility;
    }
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
