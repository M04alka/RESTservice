package ua.od.rest.controller.impl;

import ua.od.rest.controller.OrderController;
import ua.od.rest.dto.AccountOrdersDto;
import ua.od.rest.dto.OrderDto;
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
    public Response addNewOrder(OrderDto order) {
        orderService.addNewOrder(order);
        return Response.status(201).build();
    }
}