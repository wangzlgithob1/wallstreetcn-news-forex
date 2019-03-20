package com.crawler.wallstreetcnnewsforex.controller;


import com.alibaba.fastjson.JSONObject;
import com.crawler.wallstreetcnnewsforex.service.ArticleInfoService;
import com.crawler.wallstreetcnnewsforex.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WallstreetcnController {

    @Autowired
    ArticleInfoService articleInfoService;
    @Autowired
    ManagerInfoService managerInfoService;

    @GetMapping("/article/select/test")
    public JSONObject articleSelectTest(){

        JSONObject result = new JSONObject();
        result.put("data",articleInfoService.selectAll());
        return result;

    }


    @GetMapping("/manager/select/test")
    public JSONObject ManagerSelectTest(){

        JSONObject result = new JSONObject();
        result.put("data",managerInfoService.selectAll());
        return result;

    }


}
