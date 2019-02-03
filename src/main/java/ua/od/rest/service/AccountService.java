package ua.od.rest.service;

import ua.od.rest.dto.AccountDto;
import ua.od.rest.dto.NewAccountDto;


public interface AccountService {

    String loginUser(AccountDto account);
    String createNewUser(NewAccountDto accountDto);
    Boolean authentication(AccountDto account);
}
