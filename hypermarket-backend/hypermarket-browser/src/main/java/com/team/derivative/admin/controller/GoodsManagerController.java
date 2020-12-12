package com.team.derivative.admin.controller;

import com.team.derivative.admin.entity.GoodsDetails;
import com.team.derivative.admin.service.GoodManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/goods")
public class GoodsManagerController {

    @Autowired
    private GoodManagerService service;

    @RequestMapping("/getAll")
    public Map<String, List<GoodsDetails>> getGoodsAll(){
        return service.getGoodsList();
    }
}
