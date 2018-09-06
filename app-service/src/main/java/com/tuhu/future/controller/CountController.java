package com.tuhu.future.controller;

import com.alibaba.fastjson.JSON;
import com.tuhu.future.Service.CountService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.Util.JsonUtil;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderQureyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CountController {
    private static final Logger logger = LoggerFactory.getLogger(CountController.class);
    @Autowired
    private CountService countService;
    /**
     * @author yuanyi
     * @Title: CountController
     * @ProjectName future-mybatis-parent
     * @Description: 订单信息
     * @date 2018/7/11 15:25
     */
    @RequestMapping(value = "/count")
    public String  count(OrderQureyDTO orderQureyDTO){
        ApiResult apiResult=countService.selectOrder(orderQureyDTO);
        return "countlist";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String  data(Object o){
        Map<String,String> map =new HashMap<>();
        map.put("name","yuanyi");
        String a =JsonUtil.ObjectToJson(map);
        System.out.print( JsonUtil.ObjectToJson(map));
        return  a;
        }

    @RequestMapping(value = "/arrive")
    public String test(){
        return "countlist";
    }


}
