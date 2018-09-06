package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.*;
import com.tuhu.future.mybatis.integration.dal.mapper.AgencyDOMapper;
import com.tuhu.future.mybatis.integration.dal.mapper.EmployDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyDOMapper agencyDOMapper;
    @Autowired
    private EmployDOMapper employDOMapper;
    @Override
    public DataInfo<AgencyDTO> listAgency(Integer departId) {
        DataInfo<AgencyDTO> dataInfo=new DataInfo<>();
        List<AgencyDTO> agencyDTOList=new ArrayList<>();
        List<AgencyDO> agencyDOList=agencyDOMapper.selectByDepartId(departId);
        for(AgencyDO agencyDO:agencyDOList){
            Integer employeeId=agencyDO.getEmployeeId();
            AgencyDTO agencyDTO=new AgencyDTO();
            agencyDTO.setAgencyId(agencyDO.getAgencyId());
            EmployDO employDO=employDOMapper.selectByPrimaryKey(employeeId);
            if(employDO!=null) {
                agencyDTO.setEmployeeEmail(employDO.getEmployeeEmail());
                agencyDTO.setEmployeeName(employDO.getEmployeeName());
            }
            agencyDTOList.add(agencyDTO);
        }
        dataInfo.setData(agencyDTOList);
        dataInfo.setRecordsTotal(agencyDOMapper.selectNum(departId));
        return dataInfo;
    }
}
