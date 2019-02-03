package ua.od.rest.controller;

import ua.od.rest.dto.NewAccountDto;

import javax.ws.rs.core.Response;

public interface AccountController {
    Response createNewUser(NewAccountDto user);
}





