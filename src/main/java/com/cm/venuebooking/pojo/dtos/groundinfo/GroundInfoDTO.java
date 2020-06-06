package com.cm.venuebooking.pojo.dtos.groundinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: GroundInfoDTO
 * @Description: 场地信息表
 * @Author: WenG
 * @Date: 2020-04-22 11:46
 * @Version: 1.0
 **/
@ApiModel
public class GroundInfoDTO {

    @ApiModelProperty(name = "groundInfoId", value = "主键")
    private String groundInfoId;
    @ApiModelProperty(name = "venuesInfoId", value = "场馆ID")
    private String venuesInfoId;
    @ApiModelProperty(name = "venuesProjectId", value = "项目ID")
    private String venuesProjectId;
    @ApiModelProperty(name = "groundName", value = "场地名称")
    private String groundName;
    @ApiModelProperty(name = "groundLocation", value = "场地具体位置")
    private String groundLocation;
    @ApiModelProperty(name = "openCloseType", value = "场地开闭状态")
    private String openCloseType;
    @ApiModelProperty(name = "groundItemList", value = "场次列表")
    private List<GroundItemDTO> groundItemList;

    public String getGroundInfoId() {
        return groundInfoId == null ? "" : groundInfoId;
    }

    public void setGroundInfoId(String groundInfoId) {
        this.groundInfoId = groundInfoId;
    }

    public String getVenuesInfoId() {
        return venuesInfoId == null ? "" : venuesInfoId;
    }

    public void setVenuesInfoId(String venuesInfoId) {
        this.venuesInfoId = venuesInfoId;
    }

    public String getVenuesProjectId() {
        return venuesProjectId == null ? "" : venuesProjectId;
    }

    public void setVenuesProjectId(String venuesProjectId) {
        this.venuesProjectId = venuesProjectId;
    }

    public String getGroundName() {
        return groundName == null ? "" : groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getGroundLocation() {
        return groundLocation == null ? "" : groundLocation;
    }

    public void setGroundLocation(String groundLocation) {
        this.groundLocation = groundLocation;
    }

    public String getOpenCloseType() {
        return openCloseType == null ? "" : openCloseType;
    }

    public void setOpenCloseType(String openCloseType) {
        this.openCloseType = openCloseType;
    }

    public List<GroundItemDTO> getGroundItemList() {
        if (groundItemList == null) {
            return new ArrayList<>();
        }
        return groundItemList;
    }

    public void setGroundItemList(List<GroundItemDTO> groundItemList) {
        this.groundItemList = groundItemList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"groundInfoId\":\"")
                .append(groundInfoId).append('\"');
        sb.append(",\"venuesInfoId\":\"")
                .append(venuesInfoId).append('\"');
        sb.append(",\"venuesProjectId\":\"")
                .append(venuesProjectId).append('\"');
        sb.append(",\"groundName\":\"")
                .append(groundName).append('\"');
        sb.append(",\"groundLocation\":\"")
                .append(groundLocation).append('\"');
        sb.append(",\"openCloseType\":\"")
                .append(openCloseType).append('\"');
        sb.append(",\"groundItemList\":")
                .append(groundItemList);
        sb.append('}');
        return sb.toString();
    }
}
