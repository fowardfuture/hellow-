package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.AgencyDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.AgencyDOExample;
import java.util.List;

public interface AgencyDOMapper {
    long countByExample(AgencyDOExample example);

    int deleteByExample(AgencyDOExample example);

    int deleteByPrimaryKey(Integer agencyId);

    int insert(AgencyDO record);

    int insertSelective(AgencyDO record);

    List<AgencyDO> selectByExample(AgencyDOExample example);
    List<AgencyDO> selectByDepartId(Integer departId);

    AgencyDO selectByPrimaryKey(Integer agencyId);

    int updateByPrimaryKeySelective(AgencyDO record);

    int updateByPrimaryKey(AgencyDO record);
    int selectNum(Integer departId);
}