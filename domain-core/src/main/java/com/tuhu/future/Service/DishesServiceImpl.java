package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDOExample;
import com.tuhu.future.mybatis.integration.dal.mapper.DishesDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangcheng1
 * @Title: DishesServiceImpl
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1217:38
 */
@Service
public class DishesServiceImpl implements DishesService{

    @Autowired
    private DishesDOMapper dishesDOMapper;

    /**
     * 添加菜品
     * @param dishesDO
     * @return
     */
    @Override
    public int addDishes(DishesDO dishesDO) {
        return dishesDOMapper.insertSelective(dishesDO);
    }

    /**
     * 获取菜品列表
     * @param dishesDOExample
     * @return
     */
    @Override
    public List<DishesDO> listDishes(DishesDOExample dishesDOExample) {
        return dishesDOMapper.selectByExample(dishesDOExample);
    }

    /**
     * 根据ID获取菜品
     * @param disheId
     * @return
     */
    @Override
    public DishesDO getDishesById(Integer disheId) {
        return dishesDOMapper.selectByPrimaryKey(disheId);
    }

    /**
     * 编辑菜品
     * @param dishesDO
     * @return
     */
    @Override
    public int editDishes(DishesDO dishesDO) {
        return dishesDOMapper.updateByPrimaryKeySelective(dishesDO);
    }
}
