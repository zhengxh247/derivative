package com.team.derivative.admin.controller;

import com.team.derivative.admin.entity.GoodsDetailsEntity;
import com.team.derivative.admin.entity.ViewImgEntity;
import com.team.derivative.admin.service.GoodManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/goods")
@Api(tags = {"商品管理"}, description = "goods")
public class GoodsManagerController {

    @Autowired
    private GoodManagerService service;

    @ApiOperation(value = "查询首页分类菜单详情")
    @GetMapping("/getAll")
    public Map<String, List<GoodsDetailsEntity>> getGoodsAll(){
        return service.getGoodsList();
    }

    @ApiOperation(value = "查询一级分类菜单详情")
    @GetMapping("/getGroupAll")
    public Map<String, List<GoodsDetailsEntity>> getGroupAll(){
        return service.getGroupGoodsList();
    }

    @ApiOperation(value = "查询首页轮播图详情")
    @GetMapping("/getView")
    public List<ViewImgEntity> getView(){
        return service.getView();
    }
}
