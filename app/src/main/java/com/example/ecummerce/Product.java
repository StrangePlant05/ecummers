package com.example.ecummerce;

import android.net.Uri;

import java.util.HashMap;
import java.util.List;
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
    private List<String> variations;

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

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

    public Product(String id, String productName, String productDescription, String seller, double price, int quantity, int stock, Uri image, List<String> variations) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.image = image;
        this.variations = variations;
    }

    public Product(String productName, String productDescription, String seller, double price, int quantity, int stock, Uri image, List<String> variations) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
        this.image = image;
        this.variations = variations;
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
