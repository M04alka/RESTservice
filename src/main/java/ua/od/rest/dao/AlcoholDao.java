package ua.od.rest.dao;

import ua.od.rest.entity.AlcoholEntity;

import java.sql.SQLException;
import java.util.List;

public interface AlcoholDao {

    List<AlcoholEntity> getAllAlcohol() throws SQLException;

}
