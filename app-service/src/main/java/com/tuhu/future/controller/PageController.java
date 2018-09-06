package com.tuhu.future.controller;

import com.tuhu.future.Service.DishesService;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yangcheng1
 * @Title: PageController
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1121:48
 */
@Controller
public class PageController {

    @Autowired
    private DishesService dishesService;

    @RequestMapping("/home")
    public String turnToPage() {
        return "home";
    }

    @RequestMapping("/turnToDishes")
    public String turnToDishes(ModelMap model) {
        DishesDOExample example = new DishesDOExample();
        List<DishesDO> list = dishesService.listDishes(example);
        model.addAttribute("list",list);
        return "dishes";
    }

}
