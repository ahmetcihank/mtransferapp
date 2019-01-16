package com.sft.DBFactory;

import java.sql.*;

/**
 * Created by SOFTWARE02 on 15.01.2019.
 */
public class H2 extends  Database {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:moneyapp;DB_CLOSE_DELAY=-1","root","gilbertarenas");
        return connection;
    }

    @Override
    public Statement getStatement() throws SQLException {
        return  statement = connection.createStatement();
    }

    @Override
    public PreparedStatement getPreparedStatement(String sqlText) throws SQLException {
        return connection.prepareStatement(sqlText);
    }
}
