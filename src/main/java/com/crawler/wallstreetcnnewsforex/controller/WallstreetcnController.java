package com.crawler.wallstreetcnnewsforex.controller;


import com.alibaba.fastjson.JSONObject;
import com.crawler.wallstreetcnnewsforex.domain.ArticleInfo;
import com.crawler.wallstreetcnnewsforex.service.ArticleInfoService;
import com.crawler.wallstreetcnnewsforex.service.ManagerInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WallstreetcnController {

    @Autowired
    ArticleInfoService articleInfoService;
    @Autowired
    ManagerInfoService managerInfoService;

    /**
     * 获取article json
     * @return
     */
    @GetMapping("/article/select/get")
    public JSONObject articleSelectTest(){

        JSONObject result = new JSONObject();
        List<ArticleInfo> articleInfoList = articleInfoService.selectAll(1,10);
        result.put("data",articleInfoList);
        result.put("count",articleInfoList.size());
        return result;

    }

    @RequestMapping("/article/select/post")
    @ResponseBody
    public JSONObject articleSelectTest1(@RequestBody JSONObject params){

        int pageNum = params.getInteger("pageNum");
        int pageSize = params.getInteger("pageSize");

        JSONObject result = new JSONObject();

        List<ArticleInfo> articleInfoList = articleInfoService.selectAll(pageNum,pageSize);
        PageInfo<ArticleInfo> pageInfo = new PageInfo<>(articleInfoList);


        result.put("data",articleInfoList);
        result.put("count",articleInfoList.size());
        result.put("getPages",pageInfo.getPages());
        result.put("getTotal",pageInfo.getTotal());

        return result;

    }


    /**
     * 获取manager json
     * @return
     */
    @GetMapping("/manager/select/test")
    public JSONObject ManagerSelectTest(){

        JSONObject result = new JSONObject();
        result.put("data",managerInfoService.selectAll());
        return result;

    }


}
