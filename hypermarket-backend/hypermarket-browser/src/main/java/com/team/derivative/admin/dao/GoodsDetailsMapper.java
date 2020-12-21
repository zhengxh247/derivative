package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GoodsDetailsEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhengxh
 */
public interface GoodsDetailsMapper extends BaseMapper<GoodsDetailsEntity> {

    /**
     * 根据类别获取商品详情
     * @param id
     * @return
     */
    @Select("select * from goods_details where goods_category_id= #{id}")
    List<GoodsDetailsEntity> findGoodsByCategoryId(Integer id);

    /**
     * 根据一级类别获取商品详情
     * @param id
     * @return
     */
    @Select("select * from goods_details where goods_category_id in (select id from goods_category where correlation = #{id})")
    List<GoodsDetailsEntity> findGoodsByCroupId(Integer id);
}
