package com.cm.venuebooking.pojo.dtos.matchinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-15 12:08
 * @description
 */
@ApiModel
public class MatchInfoDTO {

    @ApiModelProperty(name = "matchId", value = "赛事主键")
    private String matchId;
    @ApiModelProperty(name = "projectCategory", value = "比赛项目")
    private String projectCategory;
    @ApiModelProperty(name = "frontCover", value = "宣传封面图")
    private String frontCover;
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "matchAbstract", value = "摘要")
    private String matchAbstract;
    @ApiModelProperty(name = "signTimeStr", value = "报名时间起")
    private String signTimeStr;
    @ApiModelProperty(name = "signTimeEnd", value = "报名时间止")
    private String signTimeEnd;
    @ApiModelProperty(name = "matchTimeStr", value = "比赛时间起")
    private String matchTimeStr;
    @ApiModelProperty(name = "matchTimeEnd", value = "比赛时间止")
    private String matchTimeEnd;
    @ApiModelProperty(name = "matchPlace", value = "比赛地点")
    private String matchPlace;
    @ApiModelProperty(name = "organizer", value = "主办单位")
    private String organizer;
    @ApiModelProperty(name = "undertaker", value = "承办单位")
    private String undertaker;
    @ApiModelProperty(name = "coOrganizer", value = "协办单位")
    private String coOrganizer;
    @ApiModelProperty(name = "matchSummary", value = "赛事概况")
    private String matchSummary;
    @ApiModelProperty(name = "reward", value = "奖励办法")
    private String reward;
    @ApiModelProperty(name = "route", value = "比赛路线")
    private String route;
    @ApiModelProperty(name = "signAttention", value = "报名事项")
    private String signAttention;
    @ApiModelProperty(name = "otherTips", value = "特别提示")
    private String otherTips;
    @ApiModelProperty(name = "publishType", value = "发布状态")
    private String publishType;

    public String getMatchId() {
        return matchId == null ? "" : matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

    public String getMatchAbstract() {
        return matchAbstract == null ? "" : matchAbstract;
    }

    public void setMatchAbstract(String matchAbstract) {
        this.matchAbstract = matchAbstract;
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

    public String getMatchTimeStr() {
        return matchTimeStr == null ? "" : matchTimeStr;
    }

    public void setMatchTimeStr(String matchTimeStr) {
        this.matchTimeStr = matchTimeStr;
    }

    public String getMatchTimeEnd() {
        return matchTimeEnd == null ? "" : matchTimeEnd;
    }

    public void setMatchTimeEnd(String matchTimeEnd) {
        this.matchTimeEnd = matchTimeEnd;
    }

    public String getMatchPlace() {
        return matchPlace == null ? "" : matchPlace;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
    }

    public String getOrganizer() {
        return organizer == null ? "" : organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getUndertaker() {
        return undertaker == null ? "" : undertaker;
    }

    public void setUndertaker(String undertaker) {
        this.undertaker = undertaker;
    }

    public String getCoOrganizer() {
        return coOrganizer == null ? "" : coOrganizer;
    }

    public void setCoOrganizer(String coOrganizer) {
        this.coOrganizer = coOrganizer;
    }

    public String getMatchSummary() {
        return matchSummary == null ? "" : matchSummary;
    }

    public void setMatchSummary(String matchSummary) {
        this.matchSummary = matchSummary;
    }

    public String getReward() {
        return reward == null ? "" : reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getRoute() {
        return route == null ? "" : route;
    }

    public void setRoute(String route) {
        this.route = route;
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
        sb.append("\"matchId\":\"")
                .append(matchId).append('\"');
        sb.append(",\"projectCategory\":\"")
                .append(projectCategory).append('\"');
        sb.append(",\"frontCover\":\"")
                .append(frontCover).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"matchAbstract\":\"")
                .append(matchAbstract).append('\"');
        sb.append(",\"signTimeStr\":\"")
                .append(signTimeStr).append('\"');
        sb.append(",\"signTimeEnd\":\"")
                .append(signTimeEnd).append('\"');
        sb.append(",\"matchTimeStr\":\"")
                .append(matchTimeStr).append('\"');
        sb.append(",\"matchTimeEnd\":\"")
                .append(matchTimeEnd).append('\"');
        sb.append(",\"matchPlace\":\"")
                .append(matchPlace).append('\"');
        sb.append(",\"organizer\":\"")
                .append(organizer).append('\"');
        sb.append(",\"undertaker\":\"")
                .append(undertaker).append('\"');
        sb.append(",\"coOrganizer\":\"")
                .append(coOrganizer).append('\"');
        sb.append(",\"matchSummary\":\"")
                .append(matchSummary).append('\"');
        sb.append(",\"reward\":\"")
                .append(reward).append('\"');
        sb.append(",\"route\":\"")
                .append(route).append('\"');
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
