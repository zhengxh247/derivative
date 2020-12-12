package com.team.derivative.admin.service;

import com.team.derivative.admin.dao.GoodsCategoryMapper;
import com.team.derivative.admin.dao.GoodsDetailsMapper;
import com.team.derivative.admin.entity.GoodsCategory;
import com.team.derivative.admin.entity.GoodsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengxh
 *
 */
@Service
public class GoodManagerService {

    @Autowired
    private GoodsCategoryMapper categoryMapper;

    @Autowired
    private GoodsDetailsMapper detailsMapper;

    /**
     * 获取商品列表
     * @return
     */
    public Map<String, List<GoodsDetails>> getGoodsList(){

        List<GoodsCategory> list = categoryMapper.selectList(null);
        Map<String, List<GoodsDetails>> map = new HashMap<>();
        list.forEach(r->{
            List<GoodsDetails> goodsList = detailsMapper.findGoodsByCategoryId(r.getId());
            map.put(r.getName(),goodsList);
        });
        return map;
    }
}
