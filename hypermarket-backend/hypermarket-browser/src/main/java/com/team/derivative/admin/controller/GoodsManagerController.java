package com.team.derivative.admin.controller;

import com.team.derivative.admin.exceptioin.ResultBody;
import com.team.derivative.admin.service.GoodManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultBody getGoodsAll() {
        return ResultBody.success(service.getGoodsList());
    }

    @ApiOperation(value = "查询一级分类菜单详情")
    @GetMapping("/getGroupAll")
    public ResultBody getGroupAll() {
        return ResultBody.success(service.getGroupGoodsList());
    }

    @ApiOperation(value = "商品类别模糊查询")
    @GetMapping("/select")
    public ResultBody selectByKey(@RequestParam String keyWord) {
        return ResultBody.success(service.selectByKey(keyWord));
    }


    @ApiOperation(value = "查询首页轮播图详情")
    @GetMapping("/getView")
    public ResultBody getView() {
        return ResultBody.success(service.getView());
    }
}
