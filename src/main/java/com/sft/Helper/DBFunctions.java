package com.sft.Helper;

import com.sft.DBFactory.Database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;


public class DBFunctions {
    public static void createH2(){
        Database database = Database.getDB(1);
        try
        {
           Connection connection = database.getConnection();
           Statement statement = database.getStatement();
           statement.execute("CREATE TABLE PERSONS(LOGINNAME VARCHAR(20),USERNAME VARCHAR(20),EMAIL VARCHAR(20));" );
           statement.execute("CREATE TABLE ACCOUNTS(ACCOUNTID INT,LOGINNAME VARCHAR(20)," +
                   " BALANCE INT,FOREIGN KEY(LOGINNAME) REFERENCES PERSONS(LOGINNAME) ON DELETE CASCADE) ");
           statement.execute("INSERT INTO PERSONS(LOGINNAME, USERNAME, EMAIL) VALUES('deneme', 'deneme', 'deneme@gmail.com')");
           statement.execute("INSERT INTO PERSONS(LOGINNAME, USERNAME, EMAIL) VALUES('deneme1', 'deneme', 'deneme1@gmail.com')");
           statement.execute("INSERT INTO ACCOUNTS(ACCOUNTID, LOGINNAME, BALANCE) VALUES (1,'deneme', '10000')");
           statement.execute("INSERT INTO ACCOUNTS(ACCOUNTID, LOGINNAME, BALANCE) VALUES (2,'deneme1', '8000')");
           statement.close();
           connection.close();
        }
        catch (Exception ex){
           System.out.println(ex);
        }
    }

    public static void WriteLog(Exception ex){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\SOFTWARE02\\Desktop\\log.txt"))){
            bw.write(ex.getMessage());
        }
        catch(Exception exp){
        }
    }
}
