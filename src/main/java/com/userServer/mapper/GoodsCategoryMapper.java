package com.userServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.userServer.entity.GoodsCategory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    List<GoodsCategory> findAllCategory();

    List<GoodsCategory> getCategoryType1();
}
