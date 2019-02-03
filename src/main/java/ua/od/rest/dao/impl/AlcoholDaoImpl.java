package ua.od.rest.dao.impl;

import ua.od.rest.dao.AlcoholDao;
import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.entity.AlcoholEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlcoholDaoImpl implements AlcoholDao {


    private static final String GET_ALL_ALCOHOL = "Select * from Alcohol";

    @Override
    public List<AlcoholEntity> getAllAlcohol() {
        return SQLHelper.prepareStatement(GET_ALL_ALCOHOL, statement -> {
        ResultSet resultSet = statement.executeQuery();
        List<AlcoholEntity> alcoholList = new ArrayList<>();
        while(resultSet .next()) {
            alcoholList.add(new AlcoholEntity(){{
                setId(resultSet .getInt("id"));
                setName(resultSet .getString("name"));
                setPrice(resultSet .getDouble("price"));
            }});
        }

        return alcoholList;
        });
}
}
