package com.example.ecummerce;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String id;
    private String productName;
    private String productDescription;
    private String seller;
    private double price;
    private int quantity;
    private int stock;
    private Uri image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product(String id, String productName, String productDescription, String seller, double price, int quantity, int stock, Uri image) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.image = image;
    }

    public Product(String productName, String productDescription, String seller, double price, int quantity, int stock, Uri image) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.image = image;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public Map addToMap(){
        Map map = new HashMap();

        map.put("productName", productName);
        map.put("productDescription", productDescription);
        map.put("seller", seller);
        map.put("price", price);
        map.put("quantity", quantity);
        map.put("stock", stock);


        return map;
    }
}
