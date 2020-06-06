package com.cm.venuebooking.pojo.dtos.matchinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-15 12:08
 * @description
 */
@ApiModel
public class MatchInfoListDTO {

    @ApiModelProperty(name = "matchId", value = "赛事主键")
    private String matchId;
    @ApiModelProperty(name = "frontCover", value = "宣传封面图")
    private String frontCover;
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "matchAbstract", value = "摘要")
    private String matchAbstract;
    @ApiModelProperty(name = "matchPlace", value = "比赛地点")
    private String matchPlace;
    @ApiModelProperty(name = "matchTimeStr", value = "比赛时间起")
    private String matchTimeStr;
    @ApiModelProperty(name = "matchTimeEnd", value = "比赛时间止")
    private String matchTimeEnd;


    public String getMatchId() {
        return matchId == null ? "" : matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

    public String getMatchPlace() {
        return matchPlace == null ? "" : matchPlace;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"matchId\":\"")
                .append(matchId).append('\"');
        sb.append(",\"frontCover\":\"")
                .append(frontCover).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"matchAbstract\":\"")
                .append(matchAbstract).append('\"');
        sb.append(",\"matchPlace\":\"")
                .append(matchPlace).append('\"');
        sb.append(",\"matchTimeStr\":\"")
                .append(matchTimeStr).append('\"');
        sb.append(",\"matchTimeEnd\":\"")
                .append(matchTimeEnd).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
