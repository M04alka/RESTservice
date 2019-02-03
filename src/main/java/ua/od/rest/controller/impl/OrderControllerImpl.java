package ua.od.rest.controller.impl;

import ua.od.rest.controller.OrderController;
import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.NewOrderDto;
import ua.od.rest.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bar")
public class OrderControllerImpl implements OrderController {

    public OrderService orderService;

    @GET
    @Path("{accountId}/list")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<AccountOrdersDto> getAllOrders(@PathParam("accountId") Integer accountId) {
        List<AccountOrdersDto> orderList = orderService.getAllOrders(accountId);
        return orderList;

    }

    @POST
    @Path("{accountId}/new")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response addNewOrder(NewOrderDto order, @PathParam("accountId") Integer accountId) {
        orderService.addNewOrder(order,accountId);
        return Response.status(201).build();
    }
}