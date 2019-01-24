package ua.od.rest.dto.SQLHelper;

import ua.od.rest.config.DBconfig;

import java.sql.*;



public class SQLHelper {


    protected Statement statement = null;
    protected PreparedStatement preperedStatement = null;
    protected Connection connection = null;
    //protected static final String credential = ;

   public Statement executeStatement  ( ) throws  SQLException {

       connection = DriverManager.getConnection(),);
       statement = connection.createStatement();
       return null;
   }

}
