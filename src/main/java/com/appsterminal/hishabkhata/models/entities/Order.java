package com.appsterminal.hishabkhata.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    double total;
    double paid;
    double discount;
    double due;

    @ManyToOne
    @JoinColumn(name = "fk_phone_number")
    Customer customer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;
    //Customer? customer; //local usages only
    //String? name;


    public Order() {
    }

    public Order(long id, double total, double paid, double discount, double due, Customer customer, Date createdAt) {
        this.id = id;
        this.total = total;
        this.paid = paid;
        this.discount = discount;
        this.due = due;
        this.customer = customer;
        this.createdAt = createdAt;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
