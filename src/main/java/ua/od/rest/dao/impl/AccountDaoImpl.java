package ua.od.rest.dao.impl;

import ua.od.rest.dao.AccountDao;
import ua.od.rest.dao.Helper.SQLHelper;
import ua.od.rest.entity.AccountEntity;
import ua.od.rest.entity.AlcoholEntity;
import ua.od.rest.entity.NewAccountEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    @Override
    public String createNewAccount(NewAccountEntity accountEntity) {
        String token = SQLHelper.prepareStatement("INSERT INTO User(name, password, token) values(?,?,?)", pstmt -> {
            pstmt.setString(1, accountEntity.getName());
            pstmt.setString(2, accountEntity.getPassword());
            pstmt.setString(3, accountEntity.getToken());
            return pstmt.executeUpdate();
        });
        return token;
    }

    private static final String GET_CREDENTILAS = "Select * from Account";
    @Override
    public List<AccountEntity> logIntoAccount(AccountEntity accountEntity) {
       return SQLHelper.prepareStatement(GET_CREDENTILAS, statement->{
            List<AccountEntity> accounts = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
               accounts.add(new AccountEntity(){{
                   setId(resultSet.getInt("Id"));
                   setName(resultSet.getString("Login"));
                   setPassword(resultSet.getString("Password"));
                   setToken(resultSet.getString("Token"));
               }});
            }
           return accounts;
        });
    }
}
