package com.test.springTest.mybatis;

import java.util.List;

import com.test.springTest.entity.AnimalEntity;

public interface Mybatis_AnimalDAO {

	int insertOne(AnimalEntity record);

    List<AnimalEntity> getAllByPaging();
}
