package com.example.ebankingspg.java.request;

public class AddImage {
    private String image1;
    private String image2;

    public AddImage(String image1, String image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    public AddImage() {
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }
}
