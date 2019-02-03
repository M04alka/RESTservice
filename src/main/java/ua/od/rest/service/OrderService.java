package ua.od.rest.service;

import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.OrderDto;
import ua.od.rest.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<AccountOrdersDto> getAllOrders(Integer accountId);
    String addNewOrder(OrderDto order);
}
