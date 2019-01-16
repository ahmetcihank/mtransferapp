package com.sft.DBFactory;

import java.sql.*;

/**
 * Created by SOFTWARE02 on 14.01.2019.
 */
public class Mysql extends Database {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transfer","root","paul");
        return connection;
    }

    @Override
    public Statement getStatement() throws SQLException {
        statement =connection.createStatement();
        return statement;
    }

    @Override
    public PreparedStatement getPreparedStatement(String sqlText) throws SQLException {
        return connection.prepareStatement(sqlText);
    }
}
