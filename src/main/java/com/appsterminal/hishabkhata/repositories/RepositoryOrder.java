package com.appsterminal.hishabkhata.repositories;

import com.appsterminal.hishabkhata.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RepositoryOrder extends JpaRepository<Order, Long> {
//    @Query(value = "select o.id,o.name,o.total, o.due, o.paid, o.discount, o.createdDate from orders o", nativeQuery = true)
//    List getAllOrdersWithCustomerName();

    //(SELECT c.name FROM customer c WHERE o.phone_number = c.phone_number) as name

    @Query(value = "SELECT t.* FROM orders t WHERE t.fk_phone_number=?",nativeQuery = true)
    List<Order> findByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT\n" +
            "        SUM(t.total) as total,\n" +
            "        SUM(t.paid) as paid,\n" +
            "        SUM(t.discount) as discount,\n" +
            "        SUM(t.due) as due\n" +
            "        FROM orders t \n" +
            "        WHERE t.fk_phone_number=?",nativeQuery = true)
    Map calculateTotalOrdersByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT\n" +
            "        SUM(t.total) as total,\n" +
            "        SUM(t.paid) as paid,\n" +
            "        SUM(t.discount) as discount,\n" +
            "        SUM(t.due) as due\n" +
            "        FROM orders t",nativeQuery = true)
    Map calculateTotalOrders();


    //Betwee:   "        FROM orders t WHERE t.created_at BETWEEN ? AND ?",nativeQuery = true)
    @Query(value = "SELECT\n" +
            "        COUNT(t.id) as ordersCount,\n" +
            "        SUM(t.total) as total,\n" +
            "        SUM(t.paid) as paid,\n" +
            "        SUM(t.discount) as discount,\n" +
            "        SUM(t.due) as due\n" +
            "        FROM orders t WHERE t.created_at >= ? AND t.created_at <= ?",nativeQuery = true)
    Map calculateTotalOrdersByfrom_dateToto_date(String fromDate, String toDate);

    @Query(value = "SELECT\n" +
            "        *\n" +
            "        FROM orders t WHERE t.created_at >= ? AND t.created_at <= ?",nativeQuery = true)
    List<Order> fetchAllOrdersBy_fromDate_To_toDate(String fromDate, String toDate);

    @Modifying
    @Query(value = "update orders u set u.total = ?, u.paid = ?, u.discount = ?, u.due = ? where u.id = ?", nativeQuery = true)
    int updateOrder(double total, double paid, double discount, double due, long id);
}
