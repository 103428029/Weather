package com.example.test.ui.home;

public class RV2Data {
    int weatherImg2;
    String dayList;
    String descriptionList;
    String temp2;

    public RV2Data(int weatherImg2, String dayList, String descriptionList, String temp2) {
        this.weatherImg2 = weatherImg2;
        this.dayList = dayList;
        this.descriptionList = descriptionList;
        this.temp2 = temp2;
    }

    public int getWeatherImg2() {
        return weatherImg2;
    }

    public void setWeatherImg2(int weatherImg2) {
        this.weatherImg2 = weatherImg2;
    }

    public String getDayList() {
        return dayList;
    }

    public void setDayList(String dayList) {
        this.dayList = dayList;
    }

    public String getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(String descriptionList) {
        this.descriptionList = descriptionList;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }
}
