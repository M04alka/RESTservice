package ua.od.rest.service.impl;

import ua.od.rest.dao.AccountDao;
import ua.od.rest.dto.AccountDto;
import ua.od.rest.entity.AccountEntity;
import ua.od.rest.service.AccountService;

import javax.inject.Inject;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {

    @Inject
    public AccountDao accountDao;


    @Override
    public String verify(AccountDto account) {
        return accountDao.registerAccount(new AccountEntity() {{
            setName(account.getName());
            setPassword(account.getPassword());
            setToken(UUID.randomUUID().toString());
        }});
    }

    @Override
    public String newUser(AccountDto accountDto) {
        return accountDao.registerAccount(new AccountEntity() {{
            setName(accountDto.getName());
            setPassword(accountDto.getPassword());
            setToken(UUID.randomUUID().toString());
        }});
    }
}
