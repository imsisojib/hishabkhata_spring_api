package com.appsterminal.hishabkhata.repositories;

import com.appsterminal.hishabkhata.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCustomer extends JpaRepository<Customer, String> {
    List<Customer> searchCustomerByNameIsLikeOrderByNameAsc(String name);
}
