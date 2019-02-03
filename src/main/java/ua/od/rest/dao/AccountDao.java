package ua.od.rest.dao;

import ua.od.rest.entity.AccountEntity;

import java.util.List;

public interface AccountDao {

    String  createNewAccount(AccountEntity accountEntity);
    String  logIntoAccount(AccountEntity accountEntity);


}
