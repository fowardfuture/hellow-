package com.tuhu.future.Service;

import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderQureyDTO;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderResultDTO;
import com.tuhu.future.mybatis.integration.dal.mapper.OrderDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountServiceImpl implements CountService{
   @Autowired
    private OrderDOMapper orderDOMapper;

   @Override
    public  ApiResult selectOrder(OrderQureyDTO orderDO) {
       List<OrderResultDTO> list = new ArrayList<OrderResultDTO>();
       ApiResult apiResult = new ApiResult();
       String Agency = "";
       Integer id= null;
       try {
           list = orderDOMapper.selectOrder(orderDO);
           if (orderDO.getDepartmentId() != null) {
               Agency = orderDOMapper.selectAgenceByApartId(orderDO.getDepartmentId());
           } else if (orderDO.getEmployeeId() != null) {
               Agency = orderDOMapper.selectAgencyByid(orderDO.getEmployeeId());
           }

           if (list ==null || list.size() <=1) {
               apiResult.setCode(1);
               apiResult.setMsg("无满足条件的订单");

           } else {
               for (OrderResultDTO qureyDO : list
                       ) {
                   if (orderDO.getDepartmentId() == null && orderDO.getEmployeeId() == null) {
                       Integer i = qureyDO.getDepartment_id();
                       Agency = orderDOMapper.selectAgenceByApartId(qureyDO.getDepartment_id());
                       qureyDO.setAngency_name(Agency);
                   } else {
                       qureyDO.setAngency_name(Agency);
                   }
               }
               apiResult.setData(list);
               apiResult.setCode(2);
               apiResult.setMsg("加载成功");
           }
       } catch (Exception e) {
           apiResult.setCode(3);
           apiResult.setMsg("服务器异常");
       }
       return apiResult;
   }
}
