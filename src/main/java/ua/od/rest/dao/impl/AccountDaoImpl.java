package ua.od.rest.dao.impl;

import ua.od.rest.dao.AccountDao;
import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.entity.AccountEntity;

import java.util.logging.Logger;

public class AccountDaoImpl implements AccountDao {

    Logger LOG = Logger.getLogger(AccountDaoImpl .class.getName());
    @Override
    public String registerAccount(AccountEntity accountEntity) {
        String token = SQLHelper.prepareStatement("INSERT INTO User(name, password, token) values(?,?,?)", pstmt -> {
            pstmt.setString(1, accountEntity.getName());
            pstmt.setString(2, accountEntity.getPassword());
            pstmt.setString(3, accountEntity.getToken());
            return pstmt.executeUpdate() > 0 ? accountEntity.getToken() : null;
        });
        if(token.isEmpty()) {
            LOG.warning("This user already exists!!!!");
        }
        return token;
    }

    @Override
    public String logIntoAccount(AccountEntity accountEntity) {
        return null;
    }
}
