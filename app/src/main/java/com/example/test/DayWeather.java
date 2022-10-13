package com.example.test;

public class DayWeather {
    int weatherImg;
    String temp;
    String time;

    public DayWeather (int weatherImg, String temp, String time) {
        this.weatherImg = weatherImg;
        this.temp = temp;
        this.time = time;
    }

    public int getWeatherImg() {
        return weatherImg;
    }

    public String getTemp() {
        return temp;
    }

    public String getTime() {
        return time;
    }

}
