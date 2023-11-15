package com.appsterminal.hishabkhata.models.request;
public class RequestUpdateOrder {
    long id;
    double total;
    double paid;
    double discount;
    double due;

    public RequestUpdateOrder() {
    }

    public RequestUpdateOrder(long id, double total, double paid, double discount, double due) {
        this.id = id;
        this.total = total;
        this.paid = paid;
        this.discount = discount;
        this.due = due;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
