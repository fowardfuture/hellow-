package com.tuhu.future.mybatis.integration.dal.mapper;

import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDOExample;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderQureyDTO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderResultDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDOMapper {
    long countByExample(OrderDOExample example);

    int deleteByExample(OrderDOExample example);

    int deleteByPrimaryKey(Integer orderHistoryId);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    List<OrderDO> selectByExample(OrderDOExample example);

    OrderDO selectByPrimaryKey(Integer orderHistoryId);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);

    int cancleOrder(Integer orderHistoryId);


    int checkOrder(Integer employeeId);

    List<OrderResultDTO> selectOrder(OrderQureyDTO orderDO);

    String selectAgenceByApartId(Integer department_id);

    String selectAgencyByid(Integer employee_id);

    OrderDO checkOrder(@Param("order_status")Integer order_status,@Param("employeeId")Integer employeeId);

}