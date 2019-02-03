package ua.od.rest.controller;

import ua.od.rest.entity.OrderEntity;

import java.util.List;

public interface OrderController {

    List<OrderEntity> getAllOrders();
    String addNewOrder(OrderEntity order);
}
