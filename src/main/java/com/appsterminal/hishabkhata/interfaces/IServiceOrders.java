package com.appsterminal.hishabkhata.interfaces;

import com.appsterminal.hishabkhata.models.entities.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IServiceOrders {
    Order createOrder(Order order);
    Order updateOrder(Order order);

    long countTotalOrders();
    List<Order> getAllOrders();

    List<Order> findOrdersByPhoneNumber(String phoneNumber);

    Map calculateTotalOrdersByPhoneNumber(String phoneNumber);
    Map calculateTotalOrder();
    Map calculateTotalOrderByfrom_dateToto_date(String fromDate, String toDate);

    List<Order> fetchOrdersBy_fromDate_To_toDate(String fromDate, String toDate);

    Optional<Order> findOrderById(long orderId);

    void deleteOrderById(long orderId);
}
