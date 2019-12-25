package com.codegym.models;

public class Product {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(int id, String name, double price, int code, String information) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.information = information;
    }

    private String name;
    private double price;
    private int code;
    private String information;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Product(String name, double price, int code, String information) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.information = information;
    }

    public Product() {
    }
}
