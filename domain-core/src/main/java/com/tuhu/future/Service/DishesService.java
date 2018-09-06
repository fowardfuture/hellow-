package com.tuhu.future.Service;

import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDOExample;

import java.util.List;

/**
 * @author yangcheng1
 * @Title: DishesService
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1217:36
 */
public interface DishesService {

    int addDishes(DishesDO dishesDO);

    List<DishesDO> listDishes(DishesDOExample dishesDOExample);

    DishesDO getDishesById(Integer disheId);

    int editDishes(DishesDO dishesDO);
}
