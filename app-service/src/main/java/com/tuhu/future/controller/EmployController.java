package com.tuhu.future.controller;

import com.tuhu.future.Enum.ResultEnum;
import com.tuhu.future.Service.EmployeeService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author 刘志力
 * @Title: DishesController
 * @ProjectName future-mybatis-parent
 * @Description: 用户管理
 * @date 2018/7/13 13:16
 */
@Controller
@RequestMapping(value = "/employ")
public class EmployController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    @ResponseBody
    public ApiResult add(String employeeDepartment, Integer employeeDepartmentId){
        ApiResult apiResult = new ApiResult();
        EmployDO employDO = new EmployDO();
        Session session = SecurityUtils.getSubject().getSession();
        Collection collection = session.getAttributeKeys();
        String email = session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString();

        employDO.setEmployeeDepartment(employeeDepartment);
        employDO.setEmployeeDepartmentId(employeeDepartmentId);
        employDO.setEmployeeEmail(email);

        boolean result = employeeService.insertEmploy(employDO, email);
        if(!result){
            apiResult.setCode(ResultEnum.FAIL.getCode());
            apiResult.setMsg("该用已存在");
        }

        apiResult.setCode(ResultEnum.SUCCESS.getCode());
        return apiResult;
    }


}
