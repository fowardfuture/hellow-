package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.DepartmentDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DepartmentDOExample;
import java.util.List;

public interface DepartmentDOMapper {
    long countByExample(DepartmentDOExample example);

    int deleteByExample(DepartmentDOExample example);

    int deleteByPrimaryKey(Integer departId);

    int insert(DepartmentDO record);

    int insertSelective(DepartmentDO record);

   List<DepartmentDO> selectByExample(DepartmentDOExample example);
   List<DepartmentDO> list();
    DepartmentDO selectByPrimaryKey(Integer departId);

    int updateByPrimaryKeySelective(DepartmentDO record);
    int updateByPrimaryKey(DepartmentDO record);
    int selectNum();
}