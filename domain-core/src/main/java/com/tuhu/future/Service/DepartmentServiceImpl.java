package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.DataInfo;
import com.tuhu.future.mybatis.integration.dal.dataobject.DepartmentDO;
import com.tuhu.future.mybatis.integration.dal.mapper.DepartmentDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
  @Autowired
    private DepartmentDOMapper departmentDOMapper;

   @Override
   public DataInfo<DepartmentDO> listDepartment() {
       DataInfo<DepartmentDO> dataInfo=new DataInfo<>();
       dataInfo.setData(departmentDOMapper.list());
       dataInfo.setRecordsTotal(departmentDOMapper.selectNum());
       return dataInfo;
    }

    @Override
    public int updateDepartment(Integer departId,String departName) {
        DepartmentDO departmentDO=new DepartmentDO();
        departmentDO.setDepartId(departId);
        departmentDO.setDepartName(departName);
        return departmentDOMapper.updateByPrimaryKeySelective(departmentDO);
    }

    @Override
    public int insertDepartment(String departName) {
        DepartmentDO departmentDO=new DepartmentDO();
        departmentDO.setDepartName(departName);
        return departmentDOMapper.insertSelective(departmentDO);
    }
}
