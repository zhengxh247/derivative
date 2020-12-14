package com.team.derivative.admin.service;

import com.team.derivative.admin.dao.GoodsCategoryMapper;
import com.team.derivative.admin.dao.GoodsDetailsMapper;
import com.team.derivative.admin.dao.ViewImgMapper;
import com.team.derivative.admin.entity.GoodsCategoryEntity;
import com.team.derivative.admin.entity.GoodsDetailsEntity;
import com.team.derivative.admin.entity.ViewImgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ViewImgMapper viewImgMapper;

    /**
     * 获取商品列表
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Map<String, List<GoodsDetailsEntity>> getGoodsList(){

        List<GoodsCategoryEntity> list = categoryMapper.selectList(null);
        Map<String, List<GoodsDetailsEntity>> map = new HashMap<>();
        list.forEach(r->{
            List<GoodsDetailsEntity> goodsList = detailsMapper.findGoodsByCategoryId(r.getId());
            map.put(r.getName(),goodsList);
        });
        return map;
    }

    /**
     * 轮播图接口
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ViewImgEntity> getView(){
        return viewImgMapper.selectList(null);
    }
}
