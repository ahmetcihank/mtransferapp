package com.sft.Interfaces;

import com.sft.Modals.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SOFTWARE02 on 14.01.2019.
 */
public interface PersonI {
    List<Person> getAllPerson() throws SQLException;
}
