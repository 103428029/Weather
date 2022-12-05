package com.example.test.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("weather")
    private List<WeatherDesc> weatherDesc;
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    @SerializedName("main")
    private Main main;
    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

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
    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }

}
