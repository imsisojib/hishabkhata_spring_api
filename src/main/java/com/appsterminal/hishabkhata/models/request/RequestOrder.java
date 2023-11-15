package com.appsterminal.hishabkhata.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RequestOrder {
    double total;
    double paid;
    double discount;
    double due;
    String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;

    public RequestOrder() {
    }

    public RequestOrder(double total, double paid, double discount, double due, String phoneNumber, Date createdAt) {
        this.total = total;
        this.paid = paid;
        this.discount = discount;
        this.due = due;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
