package com.tuhu.future.controller;

import com.alibaba.fastjson.JSON;
import com.tuhu.future.Service.DepartmentService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.DataInfo;
import com.tuhu.future.mybatis.integration.dal.dataobject.DepartmentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author yujia
 * @Title: DepartmentController
 * @ProjectName future-mybatis-parent
 * @Description: 部门
 * @date 2018/7/12
 */
@RequestMapping("/depart")
@Controller
public class DepartmentController {

  private final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
   @Autowired
   private DepartmentService departmentService;

/*
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "department";
    }
    */

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String listDepartment(){
       DataInfo<DepartmentDO> list=departmentService.listDepartment();
       ApiResult apiResult=new ApiResult();
       apiResult.setData(list);
       return JSON.toJSONString(apiResult);
   }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    @ResponseBody
    public String updateDepartment(Integer departId,String departName){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(departmentService.updateDepartment(departId,departName));
        return JSON.toJSONString(apiResult);
    }
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    @ResponseBody
    public String insertDepartment(String departName){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(departmentService.insertDepartment(departName));
        return JSON.toJSONString(apiResult);
    }
}
