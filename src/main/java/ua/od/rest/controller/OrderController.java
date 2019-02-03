package ua.od.rest.controller;

import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.OrderDto;


import javax.ws.rs.core.Response;
import java.util.List;

public interface OrderController {

    List<AccountOrdersDto> getAllOrders(Integer accountId);
    Response addNewOrder(OrderDto order);
}
