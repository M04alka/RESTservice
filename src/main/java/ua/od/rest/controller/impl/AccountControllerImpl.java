package ua.od.rest.controller.impl;

import ua.od.rest.controller.AccountController;
import ua.od.rest.dto.AccountDto;
import ua.od.rest.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/user")
public class AccountControllerImpl implements AccountController {

    @Inject
    public AccountService accountService;


    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loginUser(AccountDto user) {
        accountService.loginUser(user);
        return Response.ok().build();
    }

    @Path("new")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewUser(AccountDto user) {
        accountService.loginUser(user);
        return Response.status(201).build();
    }

}
