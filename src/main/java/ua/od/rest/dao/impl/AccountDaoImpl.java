package ua.od.rest.dao.impl;

import ua.od.rest.dao.AccountDao;
import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.entity.AccountEntity;

import java.util.logging.Logger;

public class AccountDaoImpl implements AccountDao {

    @Override
    public String createNewAccount(AccountEntity accountEntity) {
        String token = SQLHelper.prepareStatement("INSERT INTO User(name, password, token) values(?,?,?)", pstmt -> {
            pstmt.setString(1, accountEntity.getName());
            pstmt.setString(2, accountEntity.getPassword());
            pstmt.setString(3, accountEntity.getToken());
            return pstmt.executeUpdate();
        });
        return token;
    }

    private static final String GET_CREDENTILAS = "Select login,password from Account Where login = ? and password = ? ";
    @Override
    public String logIntoAccount(AccountEntity accountEntity) {

        return null;
    }
}
