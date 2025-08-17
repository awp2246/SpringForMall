package com.bob.springformall.model;

import java.util.Date;

public class OrderItem {

    private Integer order_item_Id;
    private Integer order_Id;
    private Integer product_Id;
    private Integer quantity;
    private Integer amount;

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
}
