package com.example.a011;

public class Car {

    int image;
    String name, price, ad;


    public Car(int image, String name, String price, String ad ) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.ad = ad;
    }


    public int getImage() {
        return image;
    }


    public void setImage(int image) {
        this.image = image;
    }




    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }




    public void setPrice(String price) {
        this.price = price;
    }


    public String getAd() {
        return ad;
    }




    public void setAd(String ad) {
        this.ad = ad;
    }


}
