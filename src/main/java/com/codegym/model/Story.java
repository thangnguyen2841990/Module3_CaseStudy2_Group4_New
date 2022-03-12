package com.codegym.model;

public class Story {
    protected int id;
    protected int categoryId;
    protected String img;
    protected String name;
    protected double price;
    protected String author;
    protected String dateSubmited;

    public Story() {
    }

    public Story(int id, int categoryId, String img, String name, double price, String author, String dateSubmited) {
        this.id = id;
        this.categoryId = categoryId;
        this.img = img;
        this.name = name;
        this.price = price;
        this.author = author;
        this.dateSubmited = dateSubmited;
    }

    public Story(int categoryId, String img, String name, double price, String author, String dateSubmited) {
        this.categoryId = categoryId;
        this.img = img;
        this.name = name;
        this.price = price;
        this.author = author;
        this.dateSubmited = dateSubmited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateSubmited() {
        return dateSubmited;
    }

    public void setDateSubmited(String dateSubmited) {
        this.dateSubmited = dateSubmited;
    }
}
