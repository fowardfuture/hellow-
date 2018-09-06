package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.CommentDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.CommentDOExample;
import java.util.List;

public interface CommentDOMapper {
    long countByExample(CommentDOExample example);

    int deleteByExample(CommentDOExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    List<CommentDO> selectByExample(CommentDOExample example);

    CommentDO selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);
}