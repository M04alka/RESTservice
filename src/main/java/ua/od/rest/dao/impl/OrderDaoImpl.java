package ua.od.rest.dao.impl;

import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.dao.OrderDao;
import ua.od.rest.entity.AccountOrdersEntity;
import ua.od.rest.entity.NewOrderEntity;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class OrderDaoImpl implements OrderDao {


    private static final String GET_ALL_ORDERS =
            "Select  Orders.Customer, \n" +
            "Alcohol.name As Alcohol_name,Orders.Count,Alcohol.price * Orders.Count as Total_Price \n" +
            "From Orders \n" +
            "Inner Join Alcohol \n" +
            "ON Orders.Alcohol_id = Alcohol.id \n" +
            "Where Account.id = ?;";

    @Override
    public List<AccountOrdersEntity> getAllOrders(Integer accountId)  {
        return SQLHelper.prepareStatement(GET_ALL_ORDERS, statement ->{
            statement.setInt(1,accountId);
            ResultSet resultSet = statement.executeQuery();
            List<AccountOrdersEntity> ordersList = new ArrayList<>();
            while(resultSet.next()){
                ordersList.add(new AccountOrdersEntity(){{
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
            "(`Account_id`, `Customer`, `Alcohol_id`, `Count`, `Price`)\n" +
            "VALUES\n" +
            "(?, ?, ?, ?, ?),";

    @Override
    public String addNewOrder(NewOrderEntity order) {
        String newOrder = SQLHelper.prepareStatement(ADD_NEW_ORDER, preparedStatement -> {
            preparedStatement.setInt(1, order.getAccountId());
            preparedStatement.setString(2, order.getCustomer());
            preparedStatement.setInt(3, order.getAlcoholId());
            preparedStatement.setInt(4, order.getCount());
            preparedStatement.setDouble(5,order.getPrice());
            return preparedStatement.executeUpdate();
        });
        return null;
    }
}
