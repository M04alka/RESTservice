package ua.od.rest.service.impl;

import ua.od.rest.dao.OrderDao;
import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.OrderDto;
import ua.od.rest.entity.OrderEntity;
import ua.od.rest.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    public OrderDao orderDao;

    @Override
    public List<AccountOrdersDto> getAllOrders(Integer accountId) {
        List<AccountOrdersDto> allOrdersList = new ArrayList<>();
        orderDao.getAllOrders(accountId).forEach(OrderEntity ->
                allOrdersList.add(new AccountOrdersDto() {
                    {
                        setCustomer(OrderEntity.getCustomer());
                        setAlcoholName(OrderEntity.getAlcoholName());
                        setCount(OrderEntity.getCount());
                        setPrice(OrderEntity.getPrice());
                    }
                })
        );
        return allOrdersList;
    }

    @Override
    public String addNewOrder(OrderDto order) {
        return orderDao.addNewOrder(new OrderEntity() {{
          //  setId(order.getId());
            setCustomer(order.getCustomer());
            setAlcoholName(order.getAlcoholName());
            setCount(order.getCount());
            setPrice(order.getPrice());
        }});
    }
}
