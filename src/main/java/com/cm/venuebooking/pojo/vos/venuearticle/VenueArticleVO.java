package com.cm.venuebooking.pojo.vos.venuearticle;

import com.cm.common.annotation.CheckEmptyAnnotation;
import com.cm.common.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: ArticleContentVO
 * @Description: 文章内容
 * @Author: WenG
 * @Date: 2020-04-03 15:37
 * @Version: 1.0
 **/
@ApiModel
public class VenueArticleVO {

    @ApiModelProperty(name = "title", value = "标题")
    @CheckEmptyAnnotation(name = "标题")
    private String title;
    @ApiModelProperty(name = "subTitle", value = "子标题")
    private String subTitle;
    @ApiModelProperty(name = "summary", value = "概述")
    private String summary;
    @ApiModelProperty(name = "link", value = "外链地址")
    private String link;
    @ApiModelProperty(name = "images", value = "图片")
    private String images;
    @ApiModelProperty(name = "source", value = "来源")
    private String source;
    @ApiModelProperty(name = "author", value = "作者")
    private String author;
    @ApiModelProperty(name = "publishDate", value = "发布时间")
    @CheckEmptyAnnotation(name = "发布时间", verifyType = "date")
    private String publishDate;
    @ApiModelProperty(name = "isPublish", value = "是否发布")
    @CheckNumberAnnotation(name = "是否发布")
    private Integer isPublish;
    @ApiModelProperty(name = "content", value = "正文")
    private String content;
    @ApiModelProperty(name = "sort", value = "排序")
    private String sort;
    @ApiModelProperty(name = "articleCategoryId", value = "文章类别")
    private String articleCategoryId;

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle == null ? "" : subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSummary() {
        return summary == null ? "" : summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLink() {
        return link == null ? "" : link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source == null ? "" : source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate == null ? "" : publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsPublish() {
        return isPublish == null ? 0 : isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSort() {
        return sort == null ? "" : sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getArticleCategoryId() {
        return articleCategoryId == null ? "" : articleCategoryId;
    }

    public void setArticleCategoryId(String articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getImages() {
        return images == null ? "" : images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"subTitle\":\"")
                .append(subTitle).append('\"');
        sb.append(",\"summary\":\"")
                .append(summary).append('\"');
        sb.append(",\"link\":\"")
                .append(link).append('\"');
        sb.append(",\"images\":\"")
                .append(images).append('\"');
        sb.append(",\"source\":\"")
                .append(source).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append(",\"publishDate\":\"")
                .append(publishDate).append('\"');
        sb.append(",\"isPublish\":")
                .append(isPublish);
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"sort\":\"")
                .append(sort).append('\"');
        sb.append(",\"articleCategoryId\":\"")
                .append(articleCategoryId).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
