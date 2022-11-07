package com.example.test.ui.home;

public class RV3Data {
    int detailImg;
    String detailData;
    String detailDesc;

    public RV3Data(int detailImg, String detailData, String detailDesc) {
        this.detailImg = detailImg;
        this.detailData = detailData;
        this.detailDesc = detailDesc;
    }

    public int getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(int detailImg) {
        this.detailImg = detailImg;
    }

    public String getDetailData() {
        return detailData;
    }

    public void setDetailData(String detailData) {
        this.detailData = detailData;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
}
