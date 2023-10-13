package com.bootcamp.Entity;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String maker;

    public Product() {
    }

    public Product(int id, String name, String description, double price, int stock, String maker) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.maker = maker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", descripcion='" + description + '\'' +
                ", precio=" + price +
                ", stock=" + stock +
                ", fabricante='" + maker + '\'' +
                '}';
    }
}
