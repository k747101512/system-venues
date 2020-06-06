package com.cm.venuebooking.pojo.vos.venuesproject;

import com.cm.common.annotation.CheckEmptyAnnotation;
import com.cm.common.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: VenuesProjectVO
 * @Description: 场馆项目表
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
@ApiModel
public class VenuesProjectVO {

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


}
