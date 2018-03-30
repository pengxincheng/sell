package com.pxc.controller;

import com.pxc.entity.ProductCategory;
import com.pxc.enums.ResultEnum;
import com.pxc.exception.SellException;
import com.pxc.form.CategoryForm;
import com.pxc.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pxc on 2018/3/30.
 */
@Controller
@RequestMapping("seller/category")
public class SellerCategoryController {

    private final Logger logger = LoggerFactory.getLogger(SellerCategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(){
        Map<String,Object> resultData = new HashMap<>();

        List<ProductCategory> productCategoryList = categoryService.getAll();
        resultData.put("categoryList",productCategoryList);
        return new ModelAndView("/category/list",resultData);
    }

    /**
     * 去往添加页面
     * @param categoryId
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId){
        Map<String,Object> resultData = new HashMap<>();
        if(null != categoryId){
            ProductCategory category = categoryService.getById(categoryId);
            resultData.put("category",category);
        }
        return new ModelAndView("/category/index",resultData);
    }

    /**
     * 保存
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult){
        Map<String,Object> resultData = new HashMap<>();
        if(bindingResult.hasErrors()){
            resultData.put("msg", bindingResult.getFieldError().getDefaultMessage());
            resultData.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", resultData);
        }
        try{
            ProductCategory productCategory = new ProductCategory();
            if(null != categoryForm.getCategoryId()){
                productCategory = categoryService.getById(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm,productCategory);
            categoryService.saveOrUpdate(productCategory);
            resultData.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/success", resultData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            resultData.put("msg", ResultEnum.ERROR.getMessage());
            resultData.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", resultData);
        }
    }
}
