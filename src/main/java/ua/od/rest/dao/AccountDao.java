package ua.od.rest.dao;

import ua.od.rest.entity.AccountEntity;
import ua.od.rest.entity.NewAccountEntity;

import java.util.List;

public interface AccountDao {

    String  createNewAccount(NewAccountEntity accountEntity);
    List<AccountEntity> logIntoAccount(AccountEntity accountEntity);


}
