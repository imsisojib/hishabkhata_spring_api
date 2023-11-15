package com.appsterminal.hishabkhata.controllers;

import com.appsterminal.hishabkhata.interfaces.IServiceCustomers;
import com.appsterminal.hishabkhata.interfaces.IServiceOrders;
import com.appsterminal.hishabkhata.models.entities.Customer;
import com.appsterminal.hishabkhata.models.entities.Order;
import com.appsterminal.hishabkhata.models.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private IServiceCustomers serviceCustomers;



    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceCustomers.createCustomer(customer)
                )
        );
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updateRequest) {

        var customerExists = serviceCustomers.findCustomerByPhoneNumber(updateRequest.getPhoneNumber());
        if(customerExists.isEmpty()){
            return ResponseEntity.status(400).body(
                    new Response(
                            "No customer found to update!",
                            null
                    )
            );
        }

        Customer customer = customerExists.get();
        customer.setAddress(updateRequest.getAddress());
        customer.setName(updateRequest.getName());
        customer.setCompanyName(updateRequest.getCompanyName());

        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceCustomers.updateCustomer(customer)
                )
        );
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestParam("phoneNumber") String phoneNumber) {

        var customerExist = serviceCustomers.findCustomerByPhoneNumber(phoneNumber);
        if(customerExist.isEmpty()){
            return ResponseEntity.status(404).body(
                    new Response(
                            "Customer not found using this phone number: "+phoneNumber,
                            null
                    )
            );
        }
        serviceCustomers.deleteCustomer(phoneNumber);

        return ResponseEntity.ok(
                new Response(
                        "Successful! Customer is deleted.",
                        null
                )
        );
    }

    @GetMapping("/count")
    public ResponseEntity<?> countTotalOrders() {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceCustomers.countTotalCustomer()
                )
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceCustomers.getAllCustomers()
                )
        );
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCustomers(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceCustomers.searchCustomers(keyword)
                )
        );
    }
}
