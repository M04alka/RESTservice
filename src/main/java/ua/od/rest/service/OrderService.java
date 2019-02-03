package ua.od.rest.service;

import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.NewOrderDto;

import java.util.List;

public interface OrderService {
    List<AccountOrdersDto> getAllOrders(Integer accountId);
    String addNewOrder(NewOrderDto order, Integer accountId);
}
