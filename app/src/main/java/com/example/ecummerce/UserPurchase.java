package com.example.ecummerce;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class UserPurchase {
    public static final String STATE_PROCESSING = "processing";
    public static final String STATE_SHIPPING = "shipping";
    public static final String STATE_DELIVERING = "delivering";
    public static final String STATE_COMPLETE = "complete";
    public static final String STATE_CANCELED = " canceled";
    private String id;
    private String productId;
    private Timestamp purchaseDate;
    private String productState;
    private double totalPrice;
    private int quantity;
    private double productPrice;
    private double rating;
    private String productStateDescription;

    public UserPurchase(String id, String productId, Timestamp purchaseDate, String productState, double totalPrice, int quantity, double productPrice, double rating, String productStateDescription) {
        this.id = id;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.productState = productState;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.rating = rating;
        this.productStateDescription = productStateDescription;
    }

    public UserPurchase(String productId, Timestamp purchaseDate, String productState, double totalPrice, int quantity, double productPrice, double rating, String productStateDescription) {
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.productState = productState;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.rating = rating;
        this.productStateDescription = productStateDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getProductStateDescription() {
        return productStateDescription;
    }

    public void setProductStateDescription(String productStateDescription) {
        this.productStateDescription = productStateDescription;
    }

    public Map addToMap(){
        Map purchase = new HashMap();


        return purchase;
    }
}

