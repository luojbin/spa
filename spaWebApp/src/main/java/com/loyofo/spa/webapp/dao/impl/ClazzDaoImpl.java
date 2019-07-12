package com.loyofo.spa.webapp.dao.impl;

import com.loyofo.spa.webapp.dao.ClazzDao;
import com.loyofo.spa.webapp.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClazzDaoImpl implements ClazzDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Clazz getClazzById(String id) {
        String sql = "select * from clazz where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Clazz.class), id);
    }

    @Override
    public List<Clazz> getAllClazz() {
        return null;
    }
}
