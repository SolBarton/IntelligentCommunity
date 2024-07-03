package com.userServer.service.impl;

import com.userServer.entity.GoodsCategory;
import com.userServer.mapper.GoodsCategoryMapper;
import com.userServer.service.GoodsCategoryService;
import com.userServer.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public ResultVO findAllCategory() {
        return ResultVO.success(goodsCategoryMapper.findAllCategory());//调用Mapper层下类的方法
    }

    public ResultVO getCategoryType1() {
        return ResultVO.success(goodsCategoryMapper.getCategoryType1());//调用Mapper层下类的方法
    }
}
