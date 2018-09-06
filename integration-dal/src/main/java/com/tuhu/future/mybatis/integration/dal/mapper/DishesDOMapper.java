package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDOExample;
import java.util.List;

public interface DishesDOMapper {
    long countByExample(DishesDOExample example);

    int deleteByExample(DishesDOExample example);

    int deleteByPrimaryKey(Integer disheId);

    int insert(DishesDO record);

    int insertSelective(DishesDO record);

    List<DishesDO> selectByExample(DishesDOExample example);

    DishesDO selectByPrimaryKey(Integer disheId);

    int updateByPrimaryKeySelective(DishesDO record);

    int updateByPrimaryKey(DishesDO record);
}