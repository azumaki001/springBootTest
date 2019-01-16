package com.test.springTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.springTest.entity.AnimalEntity;
import com.test.springTest.mybatis.Mybatis_AnimalDAO;
import com.test.springTest.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {
	@Autowired
//    private AnimalDAO dao;
	private Mybatis_AnimalDAO dao;

//    @Override
//    public List<AnimalEntity> getAllAnimals() {
//        return dao.getAll();
//    }

    @Override
    public List<AnimalEntity> getAllAnimals() {
        return dao.getAllByPaging();
    }

    @Override
    public PageInfo<AnimalEntity> getAllByPaging(int pageNum, int pageSize) {
    	//将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<AnimalEntity> animal = dao.getAllByPaging();
        PageInfo result = new PageInfo(animal);
        return result;
    }

    @Override
    public int insertOne(AnimalEntity entity) {
        return dao.insertOne(entity);
    }
}
