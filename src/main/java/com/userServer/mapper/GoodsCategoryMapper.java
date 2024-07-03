package com.userServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.userServer.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    List<GoodsCategory> getCategoryType23(@Param("id") Integer id);

    List<GoodsCategory> getCategoryType1();
}
