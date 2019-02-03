package ua.od.rest.service.impl;

import ua.od.rest.dao.AccountDao;
import ua.od.rest.dto.AccountDto;
import ua.od.rest.dto.NewAccountDto;
import ua.od.rest.entity.AccountEntity;
import ua.od.rest.entity.NewAccountEntity;
import ua.od.rest.service.AccountService;

import javax.inject.Inject;
import java.util.UUID;

public class AccountServiceImpl implements AccountService {

    private static boolean verify;

    @Inject
    public AccountDao accountDao;
    private AccountEntity accountEntity;


    @Override
    public String loginUser(AccountDto account) {
        String verification= "";
        boolean testing = authentication(account);
        if(testing = true) {
            verification= "exist";
        }
        else {
            verification= "not exist";
        }
        return verification;
    }

    @Override
    public String createNewUser(NewAccountDto accountDto) {
        return accountDao.createNewAccount(new NewAccountEntity() {{
            setName(accountDto.getName());
            setPassword(accountDto.getPassword());
            setToken(UUID.randomUUID().toString());
        }});
    }

    public Boolean authentication(AccountDto account){
        accountDao.logIntoAccount(accountEntity).forEach(AccountEntity -> {
            if(AccountEntity.getName().equals(account.getName())&&
               AccountEntity.getPassword().equals(account.getPassword())){
                verify = true;
            }
            else {
                verify = false;
            }
        });
        return verify;
    }
}
