package com.cm.venuebooking.pojo.dtos.bookingorder;

import io.swagger.annotations.ApiModelProperty;

/**
 * 场馆项目场地信息
 * @author xwangs
 * @create 2020-06-11 16:52
 * @description
 */
public class VenueProjectDTO {

    @ApiModelProperty(name = "venuesInfoId", value = "场馆ID")
    private String venuesInfoId;
    @ApiModelProperty(name = "venueName", value = "场馆名")
    private String venueName;
    @ApiModelProperty(name = "venuesProjectId", value = "项目ID")
    private String venuesProjectId;
    @ApiModelProperty(name = "projectName", value = "项目名")
    private String projectName;

    public String getVenuesInfoId() {
        return venuesInfoId == null ? "" : venuesInfoId;
    }

    public void setVenuesInfoId(String venuesInfoId) {
        this.venuesInfoId = venuesInfoId;
    }

    public String getVenueName() {
        return venueName == null ? "" : venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenuesProjectId() {
        return venuesProjectId == null ? "" : venuesProjectId;
    }

    public void setVenuesProjectId(String venuesProjectId) {
        this.venuesProjectId = venuesProjectId;
    }

    public String getProjectName() {
        return projectName == null ? "" : projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"venuesInfoId\":\"")
                .append(venuesInfoId).append('\"');
        sb.append(",\"venueName\":\"")
                .append(venueName).append('\"');
        sb.append(",\"venuesProjectId\":\"")
                .append(venuesProjectId).append('\"');
        sb.append(",\"projectName\":\"")
                .append(projectName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
