package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.EmployDOExample;
import com.tuhu.future.mybatis.integration.dal.mapper.EmployDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangcheng1
 * @Title: EmployeeServiceImpl
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1213:36
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployDOMapper employDOMapper;

    @Override
    public EmployDO selectEmployById(Integer employId) {
        return employDOMapper.selectByPrimaryKey(employId);
    }

    @Override
    public boolean insertEmploy(EmployDO employDO, String email){
        EmployDO employDOOld = employDOMapper.selectByEmail(email);
        if(employDOOld != null){
            return false;
        }

        int resutl = employDOMapper.insert(employDO);
        if(resutl == 0){
            return false;
        }
        return true;
    }

}
