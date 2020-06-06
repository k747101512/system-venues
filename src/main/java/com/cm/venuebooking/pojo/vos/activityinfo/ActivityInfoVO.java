package com.cm.venuebooking.pojo.vos.activityinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-15 12:08
 * @description
 */
@ApiModel
public class ActivityInfoVO {

    @ApiModelProperty(name = "projectCategory", value = "活动项目")
    private String projectCategory;
    @ApiModelProperty(name = "frontCover", value = "宣传封面图")
    private String frontCover;
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "activityAbstract", value = "摘要")
    private String activityAbstract;
    @ApiModelProperty(name = "signTimeStr", value = "报名时间起")
    private String signTimeStr;
    @ApiModelProperty(name = "signTimeEnd", value = "报名时间止")
    private String signTimeEnd;
    @ApiModelProperty(name = "activityTimeStr", value = "活动时间起")
    private String activityTimeStr;
    @ApiModelProperty(name = "activityTimeEnd", value = "活动时间止")
    private String activityTimeEnd;
    @ApiModelProperty(name = "activityPlace", value = "集合点")
    private String activityPlace;
    @ApiModelProperty(name = "activityCost", value = "费用")
    private String activityCost;
    @ApiModelProperty(name = "organizer", value = "主办单位、举办人")
    private String organizer;
    @ApiModelProperty(name = "activitySummary", value = "活动详情")
    private String activitySummary;
    @ApiModelProperty(name = "signAttention", value = "报名方式")
    private String signAttention;
    @ApiModelProperty(name = "otherTips", value = "特别提示")
    private String otherTips;
    @ApiModelProperty(name = "publishType", value = "发布状态")
    private String publishType;

    public String getProjectCategory() {
        return projectCategory == null ? "" : projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getFrontCover() {
        return frontCover == null ? "" : frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActivityAbstract() {
        return activityAbstract == null ? "" : activityAbstract;
    }

    public void setActivityAbstract(String activityAbstract) {
        this.activityAbstract = activityAbstract;
    }

    public String getSignTimeStr() {
        return signTimeStr == null ? "" : signTimeStr;
    }

    public void setSignTimeStr(String signTimeStr) {
        this.signTimeStr = signTimeStr;
    }

    public String getSignTimeEnd() {
        return signTimeEnd == null ? "" : signTimeEnd;
    }

    public void setSignTimeEnd(String signTimeEnd) {
        this.signTimeEnd = signTimeEnd;
    }

    public String getActivityTimeStr() {
        return activityTimeStr == null ? "" : activityTimeStr;
    }

    public void setActivityTimeStr(String activityTimeStr) {
        this.activityTimeStr = activityTimeStr;
    }

    public String getActivityTimeEnd() {
        return activityTimeEnd == null ? "" : activityTimeEnd;
    }

    public void setActivityTimeEnd(String activityTimeEnd) {
        this.activityTimeEnd = activityTimeEnd;
    }

    public String getActivityPlace() {
        return activityPlace == null ? "" : activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityCost() {
        return activityCost == null ? "" : activityCost;
    }

    public void setActivityCost(String activityCost) {
        this.activityCost = activityCost;
    }

    public String getOrganizer() {
        return organizer == null ? "" : organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getActivitySummary() {
        return activitySummary == null ? "" : activitySummary;
    }

    public void setActivitySummary(String activitySummary) {
        this.activitySummary = activitySummary;
    }

    public String getSignAttention() {
        return signAttention == null ? "" : signAttention;
    }

    public void setSignAttention(String signAttention) {
        this.signAttention = signAttention;
    }

    public String getOtherTips() {
        return otherTips == null ? "" : otherTips;
    }

    public void setOtherTips(String otherTips) {
        this.otherTips = otherTips;
    }

    public String getPublishType() {
        return publishType == null ? "" : publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"projectCategory\":\"")
                .append(projectCategory).append('\"');
        sb.append(",\"frontCover\":\"")
                .append(frontCover).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"activityAbstract\":\"")
                .append(activityAbstract).append('\"');
        sb.append(",\"signTimeStr\":\"")
                .append(signTimeStr).append('\"');
        sb.append(",\"signTimeEnd\":\"")
                .append(signTimeEnd).append('\"');
        sb.append(",\"activityTimeStr\":\"")
                .append(activityTimeStr).append('\"');
        sb.append(",\"activityTimeEnd\":\"")
                .append(activityTimeEnd).append('\"');
        sb.append(",\"activityPlace\":\"")
                .append(activityPlace).append('\"');
        sb.append(",\"activityCost\":\"")
                .append(activityCost).append('\"');
        sb.append(",\"organizer\":\"")
                .append(organizer).append('\"');
        sb.append(",\"activitySummary\":\"")
                .append(activitySummary).append('\"');
        sb.append(",\"signAttention\":\"")
                .append(signAttention).append('\"');
        sb.append(",\"otherTips\":\"")
                .append(otherTips).append('\"');
        sb.append(",\"publishType\":\"")
                .append(publishType).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
