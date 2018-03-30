package com.pxc.controller;

import com.pxc.entity.ProductCategory;
import com.pxc.entity.ProductInfo;
import com.pxc.exception.SellException;
import com.pxc.form.ProductForm;
import com.pxc.service.CategoryService;
import com.pxc.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.KeyUtil;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pxc on 2018/3/29.
 */
@Controller
@RequestMapping("seller/product")
public class SellerProductController {

    private final Logger logger = LoggerFactory.getLogger(SellerProductController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Page<ProductInfo> productInfoPage = productService.getAll(PageRequest.of(page - 1, size));
        Map<String, Object> map = new HashMap<>();
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
     * 添加/编辑初始化
     * @param productId
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId) {
        Map<String, Object> map = new HashMap<>();
        if(StringUtils.isNotBlank(productId)){
            ProductInfo productInfo = productService.getById(productId);
            map.put("productInfo",productInfo);
        }
        List<ProductCategory> productCategoryList = categoryService.getAll();
        map.put("categoryList",productCategoryList);
        return new ModelAndView("product/index", map);
    }

    @PostMapping("save")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult){
        Map<String,Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId为空, 说明是新增
            if (StringUtils.isNotEmpty(form.getProductId())) {
                productInfo = productService.getById(form.getProductId());
            }
            BeanUtils.copyProperties(form, productInfo);
            productService.saveOrUpdate(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
