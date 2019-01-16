package com.sft.Dao;

import com.sft.DBFactory.Database;
import com.sft.Interfaces.AccountI;
import com.sft.Modals.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOFTWARE02 on 15.01.2019.
 */
public class AccountImpl implements AccountI {
    @Override
    public String updateAccount(String senderName, String receiverName, int moneyAmount, int senderAccountId, int receiveraccountId){
       /*Note: Covered Both Parametric and none parametric queries*/
        Database database = Database.getDB(1);
        try {
            if(moneyAmount<=0) return "Enter a valid amount";

            Connection connection = database.getConnection();
            Statement statement = database.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  ACCOUNTS WHERE LOGINNAME ='" + senderName + "'"
            +"AND ACCOUNTID ="+senderAccountId );

            resultSet.next();
            int balance = resultSet.getInt("BALANCE");

            String loginnameSender = resultSet.getString("LOGINNAME");

            if (loginnameSender == null) return "Account does not exists";
            if (balance <= 0 || balance < moneyAmount) return "You cant transfer money";

            resultSet = statement.executeQuery("SELECT * FROM  ACCOUNTS WHERE LOGINNAME ='" + receiverName + "'"
                    +"AND ACCOUNTID ="+receiveraccountId);
            resultSet.next();
            int receiverBalance = resultSet.getInt("BALANCE");
            String loginnameReceiver = resultSet.getString("LOGINNAME");

            if (loginnameReceiver == null) return "Account does not exists";

            int updatedReceiverBalance = receiverBalance+ moneyAmount;
            int updatedSendBalance = balance - moneyAmount;

            PreparedStatement preparedStatement = database.getPreparedStatement("UPDATE ACCOUNTS SET BALANCE =? WHERE ACCOUNTID = ?");
            preparedStatement.setInt(1, updatedSendBalance);
            preparedStatement.setInt(2, senderAccountId);
            preparedStatement.execute();

            preparedStatement.clearParameters();
            preparedStatement = database.getPreparedStatement("UPDATE ACCOUNTS SET BALANCE =? WHERE ACCOUNTID = ?");
            preparedStatement.setInt(1, updatedReceiverBalance);
            preparedStatement.setInt(2, receiveraccountId);
            preparedStatement.execute();

            statement.close();
            preparedStatement.close();
            resultSet.close();
            connection.close();

            return "OK";
        }

        catch (Exception ex){
            return  "Error";
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        Database database = Database.getDB(1);
        List<Account> accountList = new ArrayList<Account>();
        try {
            Connection connection = database.getConnection();
            Statement statement = database.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM  ACCOUNTS");

            while(resultSet.next()){
                Account account = new Account(resultSet.getInt("ACCOUNTID"), resultSet.getString("LOGINNAME"),
                        resultSet.getInt("BALANCE"));
                accountList.add(account);
            }
            return  accountList;
        } catch (Exception ex) {
            return  null;
        }
    }
}
