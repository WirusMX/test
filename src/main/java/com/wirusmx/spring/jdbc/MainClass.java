package com.wirusmx.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("test.xml");
        JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
        template.execute("CREATE TABLE test (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }
}
