package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GoodsDetailsEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhengxh
 */
public interface GoodsDetailsMapper extends BaseMapper<GoodsDetailsEntity> {

    @Select("select * from goods_details where goods_category_id= #{id}")
    List<GoodsDetailsEntity> findGoodsByCategoryId(Integer id);
}
