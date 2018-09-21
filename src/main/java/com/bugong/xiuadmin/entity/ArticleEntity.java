package com.bugong.xiuadmin.entity;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.util.Generate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table()
public class ArticleEntity {
    @Id
    private String id;
    private String title;
    private String keywords;
    private String description;
    private String content;
    private String bannerName;
    private String bannerOriginalName;
    private String thumbnailName;
    private String thumbnailOriginalName;
    private String status;
    private Integer sort;
    private String categoryId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public void update(ArticleEntity articleEntity) {

        this.title = articleEntity.getTitle();
        this.keywords = articleEntity.getKeywords();
        this.description = articleEntity.getDescription();
        this.content = articleEntity.getContent();
        this.bannerName = articleEntity.getBannerName();
        this.bannerOriginalName = articleEntity.getBannerOriginalName();
        this.thumbnailName = articleEntity.getThumbnailName();
        this.thumbnailOriginalName = articleEntity.getThumbnailOriginalName();
        this.status = articleEntity.getStatus();
        this.categoryId = articleEntity.getCategoryId();
        this.sort = articleEntity.getSort();
        this.updateBy = UserContext.getUsername();
        this.updateTime = Generate.getNow();
    }
}
