package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDO;

/**
 * @author yangcheng1
 * @Title: BookService
 * @ProjectName future-mybatis-parent
 * @Description: 用户服务
 * @date 2018/7/11 22:31
 */
public interface EmployeeService {

    EmployDO selectEmployById(Integer employId);

    /**
     * 插入雇员
     * @param employDO
     * @return
     */
    boolean insertEmploy(EmployDO employDO, String email);
}
