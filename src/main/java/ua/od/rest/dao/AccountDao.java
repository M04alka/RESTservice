package ua.od.rest.dao;

import ua.od.rest.entity.AccountEntity;

import java.util.List;

public interface AccountDao {

    AccountDao  registerAccount();
    AccountDao  logIntoAccount();

}
