package com.example.demo.dao;

import com.example.demo.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       Person  resultPerson = new Person();

        resultPerson.setId(resultSet.getInt("id"));
        resultPerson.setName(resultSet.getString("name"));
        resultPerson.setAge(resultSet.getInt("age"));
        resultPerson.setEmail( resultSet.getString("email"));
        return resultPerson;
    }
}
