package ua.od.rest.dao.impl;

import ua.od.rest.dao.AlcoholDao;
import ua.od.rest.entity.AlcoholEntity;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class AlcoholDaoImpl implements AlcoholDao {

    private static final String GET_ALL_ALCOHOL = "Select * from Alcohol";
    //private static final Driver DB_DRIVER = ;

    @Override
    public List<AlcoholEntity> getAllAlcohol() {

        List<AlcoholEntity> alcoholList = new ArrayList<>();

        return null;
    }
}
