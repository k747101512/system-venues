package com.cm.venuebooking.pojo.dtos.venuesinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: VenuesInfoOwDTO
 * @Description: 场馆管理人
 * @Author: WenG
 * @Date: 2020-04-22 11:46
 * @Version: 1.0
 **/
@ApiModel
public class VenuesInfoOwDTO {

    @ApiModelProperty(name = "owId", value = "主键")
    private String owId;
    @ApiModelProperty(name = "venuesInfoId", value = "场馆ID")
    private String venuesInfoId;
    @ApiModelProperty(name = "userId", value = "管理人Id")
    private String userId;
    @ApiModelProperty(name = "userName", value = "管理人姓名")
    private String userName;

    public String getOwId() {
        return owId == null ? "" : owId;
    }

    public void setOwId(String owId) {
        this.owId = owId;
    }

    public String getVenuesInfoId() {
        return venuesInfoId == null ? "" : venuesInfoId;
    }

    public void setVenuesInfoId(String venuesInfoId) {
        this.venuesInfoId = venuesInfoId;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"owId\":\"")
                .append(owId).append('\"');
        sb.append(",\"venuesInfoId\":\"")
                .append(venuesInfoId).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
