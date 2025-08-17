package com.bob.springformall.model;

import java.util.Date;
import java.util.List;

public class Order {

    private Integer order_Id;
    private Integer user_Id;
    private Integer total_amount;
    private Date created_date;
    private Date last_modified_date;

    private List<OrderItem> orderItemList;

    public Integer getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = Integer.valueOf(order_Id);
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public void setOrder_Id(Integer order_Id) {
        this.order_Id = order_Id;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
