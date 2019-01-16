package com.test.springTest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.test.springTest.entity.AnimalEntity;
import com.test.springTest.form.AnimalForm;
import com.test.springTest.service.AnimalService;


@Controller
public class ControllerTest1 {

	@Autowired
	private AnimalService service;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ModelAndView showZooList() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("zoolist");
//		mav.addObject("animalForm", new AnimalForm());
//		return mav;

		//从数据库取出数据
        List<AnimalEntity> animals = service.getAllAnimals();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("zoolist");
        mav.addObject("animalForm", new AnimalForm());
        mav.addObject("animalsList", animals);
        return mav;
	}

	@RequestMapping(path = "/listByPaging", method = RequestMethod.GET)
	public ModelAndView showZooListByPaging(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {

		//从数据库取出数据
		PageInfo<AnimalEntity> animals = service.getAllByPaging(pageNum, pageSize);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("zoolist");
        mav.addObject("animalForm", new AnimalForm());
        mav.addObject("animalsList", animals.getList());
        return mav;
	}

	@RequestMapping(path = "/list", params = {"save"}, method = RequestMethod.POST)
    public ModelAndView doAdd(ModelAndView model, @Valid AnimalForm form, BindingResult result){

        if(result.hasErrors()){
            model.addObject("MSG", "出错啦！");
        }else{
        	service.insertOne(this.copyDataFromForm2Entity(form));
            model.addObject("MSG", "提交成功！");
        }
        model.setViewName("zoolist");

		//从数据库取出数据
        List<AnimalEntity> animals = service.getAllAnimals();
        model.addObject("animalForm", form);
        model.addObject("animalsList", animals);
        return model;
    }

	//把form里的数据copy到entity中
    private AnimalEntity copyDataFromForm2Entity(AnimalForm form){
        AnimalEntity entity = new AnimalEntity();
        entity.setName(form.getOname());
        entity.setCount(Integer.valueOf(form.getOcount()));
        entity.setMemo(form.getMemo());
        return entity;
    }
}
