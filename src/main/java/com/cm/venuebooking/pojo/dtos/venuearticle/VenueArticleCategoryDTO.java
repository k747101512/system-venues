package com.cm.venuebooking.pojo.dtos.venuearticle;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-06-14 12:58
 * @description
 */
public class VenueArticleCategoryDTO {

    @ApiModelProperty(name = "articleCategoryId", value = "文章类别ID")
    private String articleCategoryId;
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "summary", value = "标题描述")
    private String summary;

    public String getArticleCategoryId() {
        return articleCategoryId == null ? "" : articleCategoryId;
    }

    public void setArticleCategoryId(String articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary == null ? "" : summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"articleCategoryId\":\"")
                .append(articleCategoryId).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"summary\":\"")
                .append(summary).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
