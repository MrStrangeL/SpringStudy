package com.springstudy.entity;

public class Drinks {
    private int id;
    private String productName;

    public Drinks() {
    }

    public Drinks(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Drinks [id="+id+",productName="+productName+"]";
    }
}
