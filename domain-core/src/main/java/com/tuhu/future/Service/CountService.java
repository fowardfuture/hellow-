package com.tuhu.future.Service;

import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.mybatis.integration.dal.dataobject.OrderQureyDTO;

public interface CountService {

     public ApiResult selectOrder(OrderQureyDTO orderDO);
}
