package ua.od.rest.dao;

import ua.od.rest.entity.OrderEntity;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    List<OrderEntity> getAllOrders();
    String addNewOrder(OrderEntity order);
}
