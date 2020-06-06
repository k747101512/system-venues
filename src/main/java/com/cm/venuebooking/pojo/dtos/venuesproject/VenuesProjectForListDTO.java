package com.cm.venuebooking.pojo.dtos.venuesproject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: VenuesProjectForListDTO
 * @Description: 场馆项目-拓展包装类
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
@ApiModel
public class VenuesProjectForListDTO extends VenuesProjectDTO{

    @ApiModelProperty(name = "venueName", value = "所属场馆名称")
    private String venueName;
    @ApiModelProperty(name = "projectCategoryName", value = "所属项目名称")
    private String projectCategoryName;
    @ApiModelProperty(name = "facilitiesNames", value = "场地设施名称")
    private String facilitiesNames;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public String getFacilitiesNames() {
        return facilitiesNames;
    }

    public void setFacilitiesNames(String facilitiesNames) {
        this.facilitiesNames = facilitiesNames;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"venueName\":\"")
                .append(venueName).append('\"');
        sb.append(",\"projectCategoryName\":\"")
                .append(projectCategoryName).append('\"');
        sb.append(",\"facilitiesNames\":\"")
                .append(facilitiesNames).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
