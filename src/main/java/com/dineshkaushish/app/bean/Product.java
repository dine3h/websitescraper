package com.dineshkaushish.app.bean;

/**
 * Created by dineshkaushish on 20/02/2020.
 */
public class Product {

    private String title;
    private String price;
    private String description;
    private String nutritionalInfo;

    public Product(String title, String price, String description, String nutritionalInfo) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.nutritionalInfo = nutritionalInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getNutritionalInfo() {
        return nutritionalInfo;
    }
}
