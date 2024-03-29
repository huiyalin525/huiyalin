package com.huiyalin.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 此类用于抽取dao中重复代码
*/
public class JdbcDaoSupper {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource){
        jdbcTemplate=createJdbcTemplate(dataSource);
    }
    public JdbcTemplate createJdbcTemplate (DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}