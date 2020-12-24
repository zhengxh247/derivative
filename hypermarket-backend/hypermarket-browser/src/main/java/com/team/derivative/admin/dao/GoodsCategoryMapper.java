package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GoodsCategoryEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhengxh
 */
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategoryEntity> {

    /**
     * 商品二级分类排序查询（前六个）
     */
    @Select("select * from goods_category where sort<>0 order by sort")
    List<GoodsCategoryEntity> findAll();

    /**
     * 商品二级分类模糊查询id
     */
    @Select("select id from goods_category where keyword like #{keyWord} and correlation <> 0")
    Integer selectByKey(String keyWord);
}
