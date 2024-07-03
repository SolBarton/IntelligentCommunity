package com.userServer.controller;

import com.userServer.service.GoodsCategoryService;
import com.userServer.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //表示这是个首页用户业务控制器类，并且返回结果为json
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @GetMapping("/getCategoryType23")
    public ResultVO getCategoryType23(Integer id) { //根据指定一级目录的id得到二级、三级目录
        return goodsCategoryService.getCategoryType23(id);//调用Service层下类的方法
    }

    @GetMapping("/getCategoryType1")
    public ResultVO getCategoryType1() {
        return goodsCategoryService.getCategoryType1();//调用Service层下类的方法
    }

}
