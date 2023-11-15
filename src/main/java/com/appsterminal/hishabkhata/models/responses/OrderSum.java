package com.appsterminal.hishabkhata.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

public class OrderSum {
    double total;
    double paid;
    double discount;
    double due;

    public OrderSum() {
    }

    public OrderSum(double total, double paid, double discount, double due) {

        this.total = total;
        this.paid = paid;
        this.discount = discount;
        this.due = due;
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
