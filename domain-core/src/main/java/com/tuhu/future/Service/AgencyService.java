package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.AgencyDTO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DataInfo;

public interface AgencyService {
    DataInfo<AgencyDTO> listAgency(Integer departId);
}
