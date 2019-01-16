package com.sft.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by SOFTWARE02 on 14.01.2019.
 */
public abstract class Database {
    public abstract Connection getConnection() throws SQLException;
    public abstract Statement  getStatement() throws SQLException;
    public abstract PreparedStatement getPreparedStatement(String sqlText) throws SQLException;

    public  static Database getDB(int dbype){
        if(dbype == 0)
            return  new Mysql();
        else if(dbype == 1)
            return  new H2();
        else
            return new Mysql();
    }
}
