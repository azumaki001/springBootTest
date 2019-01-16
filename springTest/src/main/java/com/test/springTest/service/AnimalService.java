package com.test.springTest.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.test.springTest.entity.AnimalEntity;

public interface AnimalService {

    public List<AnimalEntity> getAllAnimals();

    public PageInfo<AnimalEntity> getAllByPaging(int pageNum, int pageSize);

    public int insertOne(AnimalEntity entity);
}
