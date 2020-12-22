package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GoodsCategoryEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengxh
 */
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategoryEntity> {

    /**
     * 商品二级分类模糊查询id
     */
    @Select("select id from goods_category where keyword like #{keyWord} and correlation <> 0")
    Integer selectByKey(String keyWord);
}
