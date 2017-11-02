package edu.sdust.iot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by WSL on 2017/5/22.
 */
public class DAO {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
