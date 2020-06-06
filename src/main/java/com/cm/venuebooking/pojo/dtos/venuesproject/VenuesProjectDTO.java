package com.cm.venuebooking.pojo.dtos.venuesproject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: VenuesProjectDTO
 * @Description: 场馆项目表
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
@ApiModel
public class VenuesProjectDTO {

    @ApiModelProperty(name = "venuesProjectId", value = "主键")
    private String venuesProjectId;
    @ApiModelProperty(name = "venueId", value = "场馆主键")
    private String venueId;
    @ApiModelProperty(name = "projectCategory", value = "项目分类")
    private String projectCategory;
    @ApiModelProperty(name = "businessHours", value = "营业时间")
    private String businessHours;
    @ApiModelProperty(name = "projectDescription", value = "项目描述")
    private String projectDescription;
    @ApiModelProperty(name = "facilities", value = "场地设施")
    private String facilities;
    @ApiModelProperty(name = "bookingType", value = "预订状态")
    private String bookingType;

    public String getVenuesProjectId() {
        return venuesProjectId == null ? "" : venuesProjectId;
    }

    public void setVenuesProjectId(String venuesProjectId) {
        this.venuesProjectId = venuesProjectId;
    }
    public String getVenueId() {
        return venueId == null ? "" : venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getProjectCategory() {
        return projectCategory == null ? "" : projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getBusinessHours() {
        return businessHours == null ? "" : businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getProjectDescription() {
        return projectDescription == null ? "" : projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getFacilities() {
        return facilities == null ? "" : facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getBookingType() {
        return bookingType == null ? "" : bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"venuesProjectId\":\"")
                .append(venuesProjectId).append('\"');
        sb.append(",\"venueId\":\"")
                .append(venueId).append('\"');
        sb.append(",\"projectCategory\":\"")
                .append(projectCategory).append('\"');
        sb.append(",\"businessHours\":\"")
                .append(businessHours).append('\"');
        sb.append(",\"projectDescription\":\"")
                .append(projectDescription).append('\"');
        sb.append(",\"facilities\":\"")
                .append(facilities).append('\"');
        sb.append(",\"bookingType\":\"")
                .append(bookingType).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
