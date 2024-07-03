package com.userServer.entity;

import java.util.Date;
import java.util.List;

public class GoodsCategory {
    private Integer id;
    private String categoryName;
    private Integer categoryType;
    private Integer parentId;
    private Date createTime;
    private Date updateTime;
    private List<GoodsCategory> children;//设置子目录

    public GoodsCategory() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<GoodsCategory> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCategory> children) {
        this.children = children;
    }

    public String getCategoryType1() {
        return "GoodsCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '}';
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", children=" + children +
                '}';
    }
}
