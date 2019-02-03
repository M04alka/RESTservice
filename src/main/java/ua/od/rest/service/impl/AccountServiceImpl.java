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
    public String loginUser(AccountDto account) {
        return accountDao.createNewAccount(new AccountEntity() {{
            setName(account.getName());
            setPassword(account.getPassword());
            setToken(UUID.randomUUID().toString());
        }});
    }

    @Override
    public String createNewUser(AccountDto accountDto) {
        return accountDao.createNewAccount(new AccountEntity() {{
            setName(accountDto.getName());
            setPassword(accountDto.getPassword());
            setToken(UUID.randomUUID().toString());
        }});
    }
}
