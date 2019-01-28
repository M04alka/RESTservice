package ua.od.rest.dao.SQLHelper;

import ua.od.rest.config.DBconfig;

import java.sql.*;



public class SQLHelper {

    public static Statement Statement()
    {
        return  null;
    }


    public static PreparedStatement preparedeStatement()
    {
        return  null;
    }



    public static Statement preStatement(String url, String user,String password,String statement2 ) throws SQLException
    {
        Connection connection = DriverManager.getConnection(DBconfig.DB_HOST,DBconfig.DB_USER,DBconfig.DB_PASSWORD);
        Statement statement = connection.createStatement();
        return  statement;
    }




}
