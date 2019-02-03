package ua.od.rest.service;

import ua.od.rest.dto.AccountDto;
import ua.od.rest.entity.AccountEntity;

public interface AccountService {

    String loginUser(AccountDto account);
    String createNewUser(AccountDto accountDto);

}
