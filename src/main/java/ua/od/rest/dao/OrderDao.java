package ua.od.rest.dao;
import ua.od.rest.entity.AccountOrdersEntity;
import ua.od.rest.entity.NewOrderEntity;

import java.util.List;

public interface OrderDao {

    List<AccountOrdersEntity> getAllOrders(Integer accountId);
    String addNewOrder(NewOrderEntity order);
}
