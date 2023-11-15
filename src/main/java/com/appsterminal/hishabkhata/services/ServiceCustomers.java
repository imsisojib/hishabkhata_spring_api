package com.appsterminal.hishabkhata.services;

import com.appsterminal.hishabkhata.interfaces.IServiceCustomers;
import com.appsterminal.hishabkhata.models.entities.Customer;
import com.appsterminal.hishabkhata.repositories.RepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCustomers implements IServiceCustomers {

    @Autowired
    RepositoryCustomer repositoryCustomer;

    @Override
    public Customer createCustomer(Customer customer) {
        return repositoryCustomer.save(customer);
    }

    @Override
    public void deleteCustomer(String phoneNumber) {
        repositoryCustomer.deleteById(phoneNumber);
    }

    @Override
    public Optional<Customer> findCustomerByPhoneNumber(String phoneNumber) {
        return repositoryCustomer.findById(phoneNumber);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repositoryCustomer.save(customer);
    }

    @Override
    public long countTotalCustomer() {
        return repositoryCustomer.count();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repositoryCustomer.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        return repositoryCustomer.searchCustomerByNameIsLikeOrderByNameAsc(keyword);
    }
}
