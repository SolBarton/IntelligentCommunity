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

    @GetMapping("/findAllCategory")
    public ResultVO findAllCategory() {
        return goodsCategoryService.findAllCategory();//调用Service层下类的方法
    }

}
