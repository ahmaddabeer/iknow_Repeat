package com.example.iknow_repeat;

public class model {

    String image;
    String name, data;

    public model(String  image, String name, String data) {
        this.image = image;
        this.name = name;
        this.data = data;
    }

    public model() {

    }


    public String  getImage() {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
