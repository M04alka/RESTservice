package ua.od.rest.controller.impl;

import ua.od.rest.controller.AlcoholController;
import ua.od.rest.dto.AlcoholDto;
import ua.od.rest.service.AlcoholService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;
@Path("/bar")
public class AlcoholControllerImpl implements AlcoholController {

    @Inject
    public AlcoholService alcoholService;

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<AlcoholDto> getAllAlcohol() {
        List<AlcoholDto> alcoholList = alcoholService.getAllAlcoholList();
        return alcoholList;
    }
}
