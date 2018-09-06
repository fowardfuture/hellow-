package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.DataInfo;
import com.tuhu.future.mybatis.integration.dal.dataobject.DepartmentDO;


/**
 * @author yujia
 * @Title: DepartmentController
 * @ProjectName future-mybatis-parent
 * @Description: 部门服务
 * @date 2018/7/12
 */
public interface DepartmentService {
   DataInfo<DepartmentDO> listDepartment();
   int updateDepartment(Integer departId,String departName);
   int insertDepartment(String departName);
}
