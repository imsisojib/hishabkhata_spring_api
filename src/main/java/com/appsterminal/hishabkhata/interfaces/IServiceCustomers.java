package com.appsterminal.hishabkhata.interfaces;

import com.appsterminal.hishabkhata.models.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface IServiceCustomers {
    Customer createCustomer(Customer customer);
    void deleteCustomer(String phoneNumber);

    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

    Customer updateCustomer(Customer customer);
    long countTotalCustomer();
    List<Customer> getAllCustomers();
    List<Customer> searchCustomers(String keyword);
}
