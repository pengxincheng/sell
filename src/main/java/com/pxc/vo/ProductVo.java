package com.pxc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by z on 2018/3/28.
 */
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryTyep;
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryTyep() {
        return categoryTyep;
    }

    public void setCategoryTyep(Integer categoryTyep) {
        this.categoryTyep = categoryTyep;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }
}
