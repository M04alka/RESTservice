package ua.od.rest.service.impl;

import ua.od.rest.dto.AlcoholDto;
import ua.od.rest.dao.AlcoholDao;
import ua.od.rest.service.AlcoholService;


import java.util.ArrayList;
import java.util.List;

public class AlcoholServiceImpl implements AlcoholService {

    public AlcoholDao alcoholDao;
    @Override
    public List<AlcoholDto> getAllAlcoholList() {
        final List<AlcoholDto> alcoholList = new ArrayList<>();
        alcoholDao.getAllAlcohol().forEach(AlcoholEntity ->
                alcoholList.add(new AlcoholDto() {
                    {
                        setId(AlcoholEntity.getId());
                        setName(AlcoholEntity.getName());
                        setPrice(AlcoholEntity.getPrice());
                    }
                })
        );
        return alcoholList;
    }
}
