package ua.od.rest.service;

import ua.od.rest.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getAllOrders();
    String addNewOrder(OrderEntity order);
}
