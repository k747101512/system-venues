package com.cm.venuebooking.pojo.dtos.activityinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-15 12:08
 * @description
 */
@ApiModel
public class ActivityInfoListDTO {

    @ApiModelProperty(name = "activityId", value = "活动主键")
    private String activityId;
    @ApiModelProperty(name = "projectCategory", value = "活动项目")
    private String projectCategory;
    @ApiModelProperty(name = "frontCover", value = "宣传封面图")
    private String frontCover;
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "activityAbstract", value = "摘要")
    private String activityAbstract;
    @ApiModelProperty(name = "activityPlace", value = "活动地点")
    private String activityPlace;
    @ApiModelProperty(name = "activityTimeStr", value = "活动时间起")
    private String activityTimeStr;
    @ApiModelProperty(name = "activityTimeEnd", value = "活动时间止")
    private String activityTimeEnd;
    @ApiModelProperty(name = "organizer", value = "主办单位、举办人")
    private String organizer;

    public String getActivityId() {
        return activityId == null ? "" : activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

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

    public String getActivityPlace() {
        return activityPlace == null ? "" : activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
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

    public String getOrganizer() {
        return organizer == null ? "" : organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"activityId\":\"")
                .append(activityId).append('\"');
        sb.append(",\"projectCategory\":\"")
                .append(projectCategory).append('\"');
        sb.append(",\"frontCover\":\"")
                .append(frontCover).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"activityAbstract\":\"")
                .append(activityAbstract).append('\"');
        sb.append(",\"activityPlace\":\"")
                .append(activityPlace).append('\"');
        sb.append(",\"activityTimeStr\":\"")
                .append(activityTimeStr).append('\"');
        sb.append(",\"activityTimeEnd\":\"")
                .append(activityTimeEnd).append('\"');
        sb.append(",\"organizer\":\"")
                .append(organizer).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
