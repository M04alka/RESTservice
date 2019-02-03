package ua.od.rest.service;

import ua.od.rest.dto.AlcoholDto;

import java.sql.SQLException;
import java.util.List;

public interface AlcoholService {
    List<AlcoholDto> getAllAlcoholList();
}
