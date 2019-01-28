package ua.od.rest.controller;

import ua.od.rest.dto.AlcoholDto;

import java.sql.SQLException;
import java.util.List;

public interface AlcoholController {
    List<AlcoholDto> getAllUpgradeList() throws SQLException;
}
