package com.test.springTest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springTest.entity.AnimalEntity;

@Repository
public class AnimalDAO {

	@Autowired
	private JdbcTemplate jdbcTmplt;

	//从animals表检索出所有数据
    public List<AnimalEntity> getAll() {
        String sql = "SELECT id, name, count, memo FROM animals";
        List<AnimalEntity> list = this.jdbcTmplt.query(sql, new BeanPropertyRowMapper<AnimalEntity>(AnimalEntity.class));
        return list;
    }

    //插入一条数据到animals表
    public int insertOne(AnimalEntity entity){
        int cnt = this.jdbcTmplt.update("INSERT INTO animals(name, count, memo) VALUES(?, ?, ?)",
                entity.getName(), entity.getCount(), entity.getMemo());
        return cnt;
    }
}
