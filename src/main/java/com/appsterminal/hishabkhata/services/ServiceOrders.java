package com.appsterminal.hishabkhata.services;

import com.appsterminal.hishabkhata.interfaces.IServiceOrders;
import com.appsterminal.hishabkhata.models.entities.Order;
import com.appsterminal.hishabkhata.repositories.RepositoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceOrders implements IServiceOrders {
    @Autowired
    RepositoryOrder repositoryOrder;

    @Override
    public Order createOrder(Order order) {
        return repositoryOrder.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        //return repositoryOrder.updateOrder(order.getTotal(), order.getPaid(), order.getDiscount(), order.getDiscount(), order.getId());
        return repositoryOrder.save(order);
    }

    @Override
    public long countTotalOrders() {
        return repositoryOrder.count();
    }

    @Override
    public List<Order> getAllOrders() {
        return repositoryOrder.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public List<Order> findOrdersByPhoneNumber(String phoneNumber) {
        return repositoryOrder.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Map calculateTotalOrdersByPhoneNumber(String phoneNumber) {
        return repositoryOrder.calculateTotalOrdersByPhoneNumber(phoneNumber);
    }

    @Override
    public Map calculateTotalOrder() {
        return repositoryOrder.calculateTotalOrders();
    }

    @Override
    public Map calculateTotalOrderByfrom_dateToto_date(String fromDate, String toDate) {
        return repositoryOrder.calculateTotalOrdersByfrom_dateToto_date(fromDate, toDate);
    }

    @Override
    public List<Order> fetchOrdersBy_fromDate_To_toDate(String fromDate, String toDate) {
        return repositoryOrder.fetchAllOrdersBy_fromDate_To_toDate(fromDate, toDate);
    }

    @Override
    public Optional<Order> findOrderById(long orderId) {
        return repositoryOrder.findById(orderId);
    }

    @Override
    public void deleteOrderById(long orderId) {
        repositoryOrder.deleteById(orderId);
    }
}
