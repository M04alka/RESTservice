package ua.od.rest.controller;

import ua.od.rest.dto.AccountDto;

import javax.ws.rs.core.Response;

public interface AccountController {
    Response createNewUser(AccountDto user);
}





