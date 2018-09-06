package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDOExample;
import java.util.List;

public interface EmployDOMapper {
    long countByExample(EmployDOExample example);

    int deleteByExample(EmployDOExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(EmployDO record);

    int insertSelective(EmployDO record);

    List<EmployDO> selectByExample(EmployDOExample example);

    EmployDO selectByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(EmployDO record);

    int updateByPrimaryKey(EmployDO record);

    EmployDO selectByEmail(String employeeEmail);
}