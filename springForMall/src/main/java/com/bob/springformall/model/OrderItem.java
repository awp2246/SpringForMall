package com.bob.springformall.model;

import java.util.Date;

public class OrderItem {

    private Integer order_item_Id;
    private Integer order_Id;
    private Integer product_Id;
    private Integer quantity;
    private Integer amount;

    private String product_Name;
    private String image_url;

    public Integer getOrder_item_Id() {
        return order_item_Id;
    }

    public void setOrder_item_Id(Integer order_item_Id) {
        this.order_item_Id = order_item_Id;
    }

    public Integer getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Integer order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Integer product_Id) {
        this.product_Id = product_Id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
