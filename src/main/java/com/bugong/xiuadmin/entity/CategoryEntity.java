package com.bugong.xiuadmin.entity;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.util.Generate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    private String id;
    private String parentId;
    private String name;
    private String keywords;
    private String description;
    private String content;
    private String bannerName;
    private String bannerOriginalName;
    private String thumbnailName;
    private String thumbnailOriginalName;
    private String status;
    private Integer sort;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerOriginalName() {
        return bannerOriginalName;
    }

    public void setBannerOriginalName(String bannerOriginalName) {
        this.bannerOriginalName = bannerOriginalName;
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }

    public String getThumbnailOriginalName() {
        return thumbnailOriginalName;
    }

    public void setThumbnailOriginalName(String thumbnailOriginalName) {
        this.thumbnailOriginalName = thumbnailOriginalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void update(CategoryEntity categoryEntity) {

        this.name = categoryEntity.getName();
        this.keywords = categoryEntity.getKeywords();
        this.description = categoryEntity.getDescription();
        this.content = categoryEntity.getContent();
        this.bannerName = categoryEntity.getBannerName();
        this.bannerOriginalName = categoryEntity.getBannerOriginalName();
        this.thumbnailName = categoryEntity.getThumbnailName();
        this.thumbnailOriginalName = categoryEntity.getThumbnailOriginalName();
        this.status = categoryEntity.getStatus();
        this.sort = categoryEntity.getSort();
        this.updateBy = UserContext.getUsername();
        this.updateTime = Generate.getNow();
    }
}
