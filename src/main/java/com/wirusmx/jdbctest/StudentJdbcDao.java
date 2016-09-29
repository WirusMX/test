package com.wirusmx.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJdbcDao implements StudentDao{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStudent(Student student) {
        jdbcTemplate.update("insert into student (name) values (?);", new Object[]{student.getName()});
    }
}
