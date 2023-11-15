package com.appsterminal.hishabkhata.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    String phoneNumber;
    String address;
    String companyName;
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createdAt;

    public Customer() {
    }

    public Customer(String phoneNumber, String address, String companyName, String name, Date createdAt) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.companyName = companyName;
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
