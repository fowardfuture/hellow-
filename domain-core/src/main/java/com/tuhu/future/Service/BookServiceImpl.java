package com.tuhu.future.Service;


import com.tuhu.future.Enum.OrderStatus;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDOExample;
import com.tuhu.future.mybatis.integration.dal.mapper.OrderDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yangcheng1
 * @Title: BookServiceImpl
 * @ProjectName future-mybatis-parent
 * @Description: 下单服务实现类
 * @date 2018/7/1122:35
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    public int placeOrder(OrderDO orderDO) {
        return orderDOMapper.insertSelective(orderDO);
    }

    @Override
    public OrderDO checkOrder(Integer employeeId,Integer order_status) {
        return orderDOMapper.checkOrder(employeeId,order_status);
    }

    @Override
    public int cancleOrder(Integer orderHistoryId) {
        return orderDOMapper.cancleOrder(orderHistoryId);
    }

    @Override
    public OrderDO getOrder(Integer orderHistoryId){
        return orderDOMapper.selectByPrimaryKey(orderHistoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderStatus orderStatus, int orderID){
        OrderDO orderDO = new OrderDO();
        orderDO.setOrderStatus(orderStatus.getCode().intValue());
        orderDO.setOrderHistoryId(orderID);
        orderDO.setOrderUpdateTime(new Date());
        return orderDOMapper.updateByPrimaryKeySelective(orderDO);
    }
}
