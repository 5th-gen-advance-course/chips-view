package com.khendec.rathana.chipsview_chipsinput.entity;

/**
 * Created by ratha on 09-Oct-17.
 */

public class Contact {
    private int id;
    private String number;
    private String name;
    private String image;
    public Contact() {}

    public Contact(String number, String name) {
        this.number = number;
        this.name = name;
        this.image="http://knongdai.com/resources/upload/3ae5bb05-9a6b-4e72-bffc-0de3894b7b61.jpg";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
