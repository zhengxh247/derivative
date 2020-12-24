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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhengxh
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
     * 获取二级分类商品列表
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List getGoodsList() {
        List<GoodsCategoryEntity> list = categoryMapper.findAll();
        List result = new ArrayList();
        //一级目录
        Integer parent = 0;
        list.forEach(r -> {
            if (!parent.equals(r.getCorrelation())) {
                Map map = new HashMap<>();
                List<GoodsDetailsEntity> goodsList = detailsMapper.findGoodsByCategoryId(r.getId());
                map.put("title", r.getKeyword());
                map.put("data", goodsList);
                result.add(map);
            }
        });
        return result;
    }

    /**
     * 获取一级分类商品列表
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List getGroupGoodsList() {

        List<GoodsCategoryEntity> list = categoryMapper.selectList(null);
        //一级目录
        Integer parent = 0;
        List<GoodsCategoryEntity> array = list.stream().filter(r -> parent.equals(r.getCorrelation())).collect(Collectors.toList());
        List result = new ArrayList();
        array.forEach(r -> {
            List<GoodsDetailsEntity> goodsList = detailsMapper.findGoodsByCroupId(r.getId());
            Map map = new HashMap<>();
            map.put("title", r.getKeyword());
            map.put("data", goodsList);
            result.add(map);
        });
        return result;
    }

    /**
     * 商品二级分类模糊查询
     */
    @Transactional(rollbackFor = Exception.class)
    public List<GoodsDetailsEntity> selectByKey(String keyWord) {
        Integer id = categoryMapper.selectByKey(keyWord);
        return detailsMapper.findGoodsByCategoryId(id);
    }

    /**
     * 轮播图接口
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ViewImgEntity> getView() {
        return viewImgMapper.selectList(null);
    }
}
