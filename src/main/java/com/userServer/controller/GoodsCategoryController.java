package com.userServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //表示这是个首页用户业务控制器类，并且返回结果为json
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {

    @GetMapping("/findAllCategory")
    public void findAllCategory() {
        //继续创建业务层的代码逻辑(2024年7月3日)
        //.......
    }

}
