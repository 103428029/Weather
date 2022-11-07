package com.example.test.ui.home;

public class RV1Data {
    int weatherImg;
    String temp;
    String time;

    public RV1Data(int weatherImg, String temp, String time) {
        this.weatherImg = weatherImg;
        this.temp = temp;
        this.time = time;
    }

    public int getWeatherImg() {
        return weatherImg;
    }

    public void setWeatherImg(int weatherImg) {
        this.weatherImg = weatherImg;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
