package com.tuhu.future.Service;

import com.tuhu.future.Enum.OrderStatus;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDO;

/**
 * @author yangcheng1
 * @Title: BookService
 * @ProjectName future-mybatis-parent
 * @Description: 下单服务
 * @date 2018/7/1122:31
 */
public interface BookService {

    int placeOrder(OrderDO orderDO);

    /**
     * 判断用户是否已经下单
     * @param employeeId
     * @return
     */
    OrderDO checkOrder(Integer employeeId, Integer order_status);

    int cancleOrder(Integer orderHistoryId);

    /**
     * 根据订单记录id查询订单状态
     * @param orderHistoryId
     * @return
     */
    OrderDO getOrder(Integer orderHistoryId);

    /**
     * 更新订单状态
     * @param orderStatus
     * @param orderID
     * @return
     */
    public int updateByPrimaryKeySelective(OrderStatus orderStatus, int orderID);
}
