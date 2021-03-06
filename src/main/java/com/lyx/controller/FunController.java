package com.lyx.controller;

import cn.hutool.core.date.DatePattern;
import com.lyx.common.CommonResult;
import com.lyx.service.FunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FunController
{
    @Autowired
    @Qualifier("funService")
    private FunService funService;

    /**
     * 获得车次数据
     */
    @GetMapping("/get-data")
    public CommonResult getData(@RequestParam String startCityId, @RequestParam String startCityName,
                                @RequestParam String endCityName, @RequestParam @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN) Date startDate)
    {
        return funService.getData(startCityId, startCityName, endCityName, startDate);
    }

    /**
     * 获得要缓存的，出发地点的数据.
     * @return 出发地点的数据
     */
    @GetMapping("/getCacheStartPoint")
    public CommonResult getCacheStartPoint()
    {
        return funService.getCacheStartPoint();
    }

    /**
     * 获得要缓存的，结束地点的数据.
     * @param startId 出发地点的id
     * @return 终点地址的数据
     */
    @GetMapping("/getCacheEndPoint")
    public CommonResult getCacheEndPoint(@RequestParam String startId)
    {
        return funService.getCacheEndPoint(startId);
    }
}
