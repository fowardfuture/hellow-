package com.tuhu.future.controller;

import com.tuhu.future.BizException;
import com.tuhu.future.Enum.ResultEnum;
import com.tuhu.future.Service.DishesService;
import com.tuhu.future.Util.ApiResult;
import com.tuhu.future.Util.Contants;
import com.tuhu.future.Util.FileUtil;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDO;
import com.tuhu.future.mybatis.integration.dal.dataobject.DishesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author yangcheng1
 * @Title: DishesController
 * @ProjectName future-mybatis-parent
 * @Description: 菜品管理
 * @date 2018/7/12 17:16
 */
@Controller
@RequestMapping("dishes")
public class DishesController {

    private final static Logger logger = LoggerFactory.getLogger(DishesController.class);

    @Autowired
    private DishesService dishesService;

    /**
     * 新增菜品
     * @param
     * @param file
     * @return
     */
    @PostMapping(value = "/add",consumes = "multipart/form-data")
    public String addDishes(@RequestParam(name = "disheName") String disheName,
                               @RequestParam(name = "disheDes") String disheDes,
                               @RequestParam(name = "uploadfile") MultipartFile file) {

        if (disheName == null) {
            throw new BizException("餐品名称不能为空");
        }
        if (disheDes == null) {
            throw new BizException("菜品内容不能为空");
        }
        if (FileUtil.checkSuffixName(file)) {
            throw new BizException("请上传照片");
        }
        DishesDO dishesDO = new DishesDO();
        FileUtil.uploadFile(file);
        dishesDO.setDisheCreateTime(new Date());
        dishesDO.setDisheUpdateTime(new Date());
        dishesDO.setDisheName(disheName);
        dishesDO.setDisheDes(disheDes);
        dishesDO.setDishePhoto(Contants.FILEPATH);
        dishesService.addDishes(dishesDO);

        return "dishes";
    }

    /**
     * 根据ID获取菜品
     * @param disheId
     * @return
     */
    @PostMapping("/view")
    @ResponseBody
    public ApiResult viewDishes(Integer disheId) {

        if (StringUtils.isEmpty(disheId)) {
            throw new BizException("菜品ID不能为空");
        }
        ApiResult apiResult = new ApiResult();
        DishesDTO dishesDTO = new DishesDTO();
        try {
            DishesDO dishesDO = dishesService.getDishesById(disheId);
            dishesDTO.setEditDishesDes(dishesDO.getDisheDes());
            dishesDTO.setEditDishesName(dishesDO.getDisheName());
            dishesDTO.setEditDishesId(dishesDO.getDisheId());
            apiResult.setData(dishesDTO);
        } catch (Exception e) {
            apiResult.setCode(ResultEnum.FAIL.getCode());
            apiResult.setMsg("查询失败");
        }
        return apiResult;
    }


    @PostMapping(value = "/edit",consumes = "multipart/form-data")
    public String editDishes(DishesDTO dishesDTO) {
        //上传文件
        DishesDO dishesDO = new DishesDO();
        dishesDO.setDisheUpdateTime(new Date());
        dishesDO.setDishePhoto(Contants.FILEPATH);
        dishesDO.setDisheId(dishesDTO.getEditDishesId());

        dishesService.editDishes(dishesDO);

        return "dishes";
    }

}
