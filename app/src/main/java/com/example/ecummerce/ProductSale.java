package com.example.ecummerce;

public class ProductSale {
     private String id;
     private String costumerId;
     private double rating;
     private int purchaseQuantity;

    public ProductSale(String id, String costumerId, double rating, int purchaseQuantity) {
        this.id = id;
        this.costumerId = costumerId;
        this.rating = rating;
        this.purchaseQuantity = purchaseQuantity;
    }

    public ProductSale(String costumerId, double rating, int purchaseQuantity) {
        this.costumerId = costumerId;
        this.rating = rating;
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(String costumerId) {
        this.costumerId = costumerId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}
