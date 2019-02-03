package ua.od.rest.dao.impl;

import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.dao.OrderDao;
import ua.od.rest.entity.OrderEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class OrderDaoImpl implements OrderDao {


    private static final String GET_ALL_ORDERS =
            "Select Account.id As Account_id, Orders.Customer, \n" +
            "Alcohol.name As Alcohol_name,Orders.Count,Alcohol.price * Orders.Count as Total_Price \n" +
            "From Account \n" +
            "Inner Join Orders \n" +
            "ON Account.Order_id = Orders.id \n" +
            "Inner Join Alcohol \n" +
            "ON Orders.Alcohol_id = Alcohol.id;";

    @Override
    public List<OrderEntity> getAllOrders()  {
        return SQLHelper.prepareStatement(GET_ALL_ORDERS, statement ->{
            ResultSet resultSet = statement.executeQuery();
            List<OrderEntity> ordersList = new ArrayList<>();
            while(resultSet.next()){
                ordersList.add(new OrderEntity(){{
                    setId(resultSet.getInt("Account_id"));
                    setCustomer(resultSet.getString("Customer"));
                    setAlcoholName(resultSet.getString("Alcohol_name"));
                    setCount(resultSet.getInt("Count"));
                    setPrice(resultSet.getFloat("Total_Price"));
                }});
            }
            return ordersList;
        });

    }

    private static final String ADD_NEW_ORDER =
            "INSERT INTO `Order`\n" +
            "(`id`, `Customer`, `Alcohol_id`, `count`)\n" +
            "VALUES\n" +
            "    (?, ?, ?, ?),";

    @Override
    public String addNewOrder(OrderEntity order) {
        String newOrder = SQLHelper.prepareStatement(ADD_NEW_ORDER, preparedStatement -> {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getCustomer());
            preparedStatement.setString(3, order.getAlcoholName());
            preparedStatement.setInt(4, order.getCount());
            preparedStatement.setDouble(5,order.getPrice());
            return preparedStatement.executeUpdate();
        });
        return newOrder;
    }
}
