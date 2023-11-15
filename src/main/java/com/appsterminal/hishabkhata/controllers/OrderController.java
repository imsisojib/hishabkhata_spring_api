package com.appsterminal.hishabkhata.controllers;

import com.appsterminal.hishabkhata.interfaces.IServiceCustomers;
import com.appsterminal.hishabkhata.interfaces.IServiceOrders;
import com.appsterminal.hishabkhata.models.entities.Order;
import com.appsterminal.hishabkhata.models.request.RequestOrder;
import com.appsterminal.hishabkhata.models.request.RequestUpdateOrder;
import com.appsterminal.hishabkhata.models.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IServiceOrders serviceOrders;

    @Autowired
    private IServiceCustomers serviceCustomers;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrder requestOrder) {
        var customer = serviceCustomers.findCustomerByPhoneNumber(requestOrder.getPhoneNumber());
        if(customer.isEmpty()){
            //means no customer found
            return ResponseEntity.status(400).body(
                    new Response(
                            "No customer found with this phone number: "+requestOrder.getPhoneNumber(),
                            null
                    )
            );
        }

        Order newOrder = new Order();
        newOrder.setCustomer(customer.get());
        newOrder.setTotal(requestOrder.getTotal());
        newOrder.setPaid(requestOrder.getPaid());
        newOrder.setDiscount(requestOrder.getDiscount());
        newOrder.setDue(requestOrder.getDue());
        newOrder.setCreatedAt(requestOrder.getCreatedAt());

        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.createOrder(newOrder)
                )
        );
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody RequestUpdateOrder requestOrder) {
        var orderExists = serviceOrders.findOrderById(requestOrder.getId());
        if(orderExists.isEmpty()){
            //means no customer found
            return ResponseEntity.status(400).body(
                    new Response(
                            "No order found to update!",
                            null
                    )
            );
        }

        Order newOrder = orderExists.get();
        newOrder.setTotal(requestOrder.getTotal());
        newOrder.setPaid(requestOrder.getPaid());
        newOrder.setDiscount(requestOrder.getDiscount());
        newOrder.setDue(requestOrder.getDue());

        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.updateOrder(newOrder)
                )
        );
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteOrder(@RequestParam("orderId") long orderId) {

        var orderExists = serviceOrders.findOrderById(orderId);
        if(orderExists.isEmpty()){
            return ResponseEntity.status(404).body(
                    new Response(
                            "No associate order is found!",
                            null
                    )
            );
        }
        serviceOrders.deleteOrderById(orderId);

        return ResponseEntity.ok(
                new Response(
                        "Successful! Order is deleted.",
                        null
                )
        );
    }

    @GetMapping("/count")
    public ResponseEntity<?> countTotalOrders() {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.countTotalOrders()
                )
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.getAllOrders()
                )
        );
    }

    @GetMapping("/find")
    public ResponseEntity<?> findOrdersByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.findOrdersByPhoneNumber(phoneNumber)
                )
        );
    }

    @GetMapping("/calculateTotal")
    public ResponseEntity<?> calculateOrdersByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        serviceOrders.calculateTotalOrdersByPhoneNumber(phoneNumber)
                )
        );
    }

    @GetMapping("/ordersReport")
    public ResponseEntity<?> calculateOrders(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

        List<Order> orders = new ArrayList<>();
        Map<String , Object> dataMap = new HashMap<String , Object>();
        if(fromDate==null || fromDate.isEmpty() || toDate==null || toDate.isEmpty()){
            //gets all data
            orders = serviceOrders.getAllOrders();
            Map<String, Object> result = serviceOrders.calculateTotalOrder();
            for (String key : result.keySet()){
                dataMap.put(key, result.get(key));
            }
            dataMap.put("data", orders);


            return ResponseEntity.ok(
                    new Response(
                            "Successful",
                            dataMap
                    )
            );
        }

        orders = serviceOrders.fetchOrdersBy_fromDate_To_toDate(fromDate, toDate);
        Map<String, Object> result = serviceOrders.calculateTotalOrderByfrom_dateToto_date(fromDate, toDate);
        for (String key : result.keySet()){
            dataMap.put(key, result.get(key));
        }
        dataMap.put("data", orders);

        return ResponseEntity.ok(
                new Response(
                        "Successful",
                        dataMap
                )
        );
    }

}
