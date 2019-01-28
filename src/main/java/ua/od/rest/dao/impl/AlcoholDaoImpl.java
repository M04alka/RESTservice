package ua.od.rest.dao.impl;

import ua.od.rest.config.DBconfig;
import ua.od.rest.dao.AlcoholDao;

import ua.od.rest.entity.AlcoholEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholDaoImpl implements AlcoholDao {


    private static final String GET_ALL_ALCOHOL = "Select * from Alcohol";
    //private static final Driver DB_DRIVER = ;

    @Override
    public List<AlcoholEntity> getAllAlcohol() throws SQLException {

        Connection connection = DriverManager.getConnection(DBconfig.DB_HOST,DBconfig.DB_USER,DBconfig.DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(GET_ALL_ALCOHOL);
        List<AlcoholEntity> alcoholList = new ArrayList<>();
        while(rs.next())
        {
            alcoholList.add(new AlcoholEntity(){{
                setId(rs.getInt("id"));
                setName(rs.getString("name"));
                setPrice(rs.getDouble("price"));
            }});
        }

        return alcoholList;
    }

}
