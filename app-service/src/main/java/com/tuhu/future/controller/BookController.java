package com.tuhu.future.controller;

import com.tuhu.future.BizException;
import com.tuhu.future.Enum.OrderStatus;
import com.tuhu.future.Enum.ResultEnum;
import com.tuhu.future.Service.BookService;
import com.tuhu.future.Service.EmployeeService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author yangcheng1
 * @Title: BookController
 * @ProjectName future-mybatis-parent
 * @Description: 下单
 * @date 2018/7/1121:57
 */
@RequestMapping("/food/booking")
@RestController
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ApiResult placeOrder(Integer dishesId) {

        if (StringUtils.isEmpty(dishesId)) {
            throw new BizException("菜品ID不能为空");
        }
        ApiResult apiResult = new ApiResult();
        //根据用户id获取用户名
        EmployDO employDO = employeeService.selectEmployById(1);
        //订单创建
        OrderDO orderDO = new OrderDO();
        orderDO.setDishesId(dishesId);
        orderDO.setOrderStatus(OrderStatus.ORDER_DONE.getCode());
        orderDO.setEmployeeId(1);
        orderDO.setOrderCreateTime(new Date());
        orderDO.setOrderUpdateTime(new Date());
        OrderDTO orderDTO = new OrderDTO();
        try {
            //判断是否已经下餐
            OrderDO res = bookService.checkOrder(1,OrderStatus.ORDER_DONE.getCode());
            if (res != null) {
                throw new BizException("用户已经下单");
            }
            bookService.placeOrder(orderDO);
            BeanUtils.copyProperties(orderDO,orderDTO);
            orderDTO.setEmployeeName(employDO.getEmployeeName());
            apiResult.setData(orderDTO);
            apiResult.setCode(ResultEnum.SUCCESS.getCode());
            apiResult.setMsg("下单成功");
        }catch (BizException e) {
            logger.error("{}重复下单",9527);
            apiResult.setCode(ResultEnum.FAIL.getCode());
            apiResult.setMsg("下单失败");
        }
        return apiResult;
    }

    @PostMapping("/cancle")
    public ApiResult cancleOrder(Integer orderHistoryId) {

        if (StringUtils.isEmpty(orderHistoryId)) {
            throw new BizException("订单id为空");
        }
        ApiResult apiResult = new ApiResult();
        try {
            bookService.cancleOrder(orderHistoryId);
            apiResult.setCode(ResultEnum.SUCCESS.getCode());
            apiResult.setMsg("取消成功");
        }catch (BizException e) {
            logger.error("{}",e.getMessage());
            apiResult.setCode(ResultEnum.FAIL.getCode());
        }
        return apiResult;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @PostMapping("/confirm")
    @ResponseBody
    public ApiResult confirm(Integer orderId, HttpSession httpSession){

        ApiResult apiResult = new ApiResult();
        EmployDO employDO = (EmployDO)httpSession.getAttribute("employ");

        OrderDO orderDO = bookService.getOrder(orderId);
        if(orderDO.getOrderStatus().intValue() != OrderStatus.ORDER_UNPICK.getCode().intValue()){
            apiResult.setCode(ResultEnum.FAIL.getCode());
            apiResult.setMsg("订单状态不正确");
            return apiResult;
        }

//        if(orderDO.getEmployeeId().intValue() != employDO.getEmployeeId().intValue()){
//            apiResult.setCode(ResultEnum.FAIL.getCode());
//            apiResult.setMsg("当前用户没有权限");
//            return apiResult;
//        }

        int result = bookService.updateByPrimaryKeySelective(OrderStatus.ORDER_SURE, orderDO.getOrderHistoryId());
        if(result == 0){
            apiResult.setCode(ResultEnum.FAIL.getCode());
            apiResult.setMsg("更新错误");
        }
        apiResult.setCode(ResultEnum.SUCCESS.getCode());
        return  apiResult;
    }
}
