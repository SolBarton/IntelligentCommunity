package com.userServer.mapper;

import com.userServer.entity.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsCategoryMapperTest {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Test
    public void findAllCategory() {
        for (GoodsCategory goodsCategory : goodsCategoryMapper.findAllCategory()) {
            System.out.println(goodsCategory);//测试已通过
        }
    }

}
