package com.tuhu.future.controller;

import com.tuhu.future.Service.AgencyService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.AgencyDTO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DataInfo;
import com.alibaba.fastjson.JSON;
import com.tuhu.future.mybatis.integration.dal.mapper.AgencyDOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yujia
 * @Title: AgencyController
 * @ProjectName future-mybatis-parent
 * @Description: 部门代理人
 * @date 2018/7/13
 */
@RequestMapping("/agency")
@Controller
public class AgencyController {
    private final static Logger logger = LoggerFactory.getLogger(AgencyController.class);
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private AgencyDOMapper agencyDOMapper;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String listAgency(Integer departId){

            DataInfo<AgencyDTO> list=agencyService.listAgency(departId);
            ApiResult apiResult=new ApiResult();
            apiResult.setData(list);
            return JSON.toJSONString(apiResult);


    }
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ResponseBody
    public Integer count(){
        return agencyDOMapper.selectNum(2);
    }
}
