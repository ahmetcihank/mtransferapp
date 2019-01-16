package com.sft.Dao;

import com.sft.DBFactory.Database;
import com.sft.Interfaces.PersonI;
import com.sft.Modals.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOFTWARE02 on 14.01.2019.
 */
public class PersonImp implements PersonI{

    private static final String SQLGETALL ="SELECT * FROM PERSONS";
    @Override
    public List<Person> getAllPerson() throws SQLException {

        Database database = Database.getDB(1);
        List<Person> personList = new ArrayList<Person>();

        try {
            Connection connection= database.getConnection();
            Statement statement = database.getStatement();
            ResultSet resultSet = statement.executeQuery(SQLGETALL);

            while(resultSet.next()){
                Person person = new Person(resultSet.getString("LOGINNAME"), resultSet.getString("USERNAME"),
                        resultSet.getString("EMAIL"));
                personList.add(person);
            }
            connection.close();
            statement.close();
            resultSet.close();
            return personList;
        }
        catch (Exception exp){
            return  null;
        }
    }
}
