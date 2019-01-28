package ua.od.rest.controller.impl;

import ua.od.rest.controller.AccountController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class AccountControllerImpl implements AccountController {
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() {

        return "Login here\n";}

}
