package ua.od.rest.controller.impl;

import ua.od.rest.controller.AccountController;
import ua.od.rest.dto.AccountDto;
import ua.od.rest.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/user")
public class AccountControllerImpl implements AccountController {

    @Inject
    public AccountService accountService;


    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loginUser(AccountDto user) {
        String token = accountService.verify(user);

        Cookie preCookie = new Cookie("token", token, "/", "", 1);
        NewCookie newCookie = new NewCookie(preCookie, "Added cookie and logged in", -1, false);
        return Response.ok().cookie(newCookie).build();
    }

    @Path("new")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewUser(AccountDto user) {
        String token = accountService.verify(user);
        if(token == null) {
            token = accountService.newUser(user);
        }
        Cookie preCookie = new Cookie("token", token, "/", "", 1);
        NewCookie newCookie = new NewCookie(preCookie, "Created new user and logged in/Or login if this user is exist", -1, false);
        return javax.ws.rs.core.Response.status(201).entity("User").cookie(newCookie).build();
    }

}
