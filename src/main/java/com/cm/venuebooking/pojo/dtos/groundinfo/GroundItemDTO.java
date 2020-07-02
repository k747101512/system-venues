package com.cm.venuebooking.pojo.dtos.groundinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-06-02 21:12
 * @description
 */
@ApiModel
public class GroundItemDTO {

    @ApiModelProperty(name = "groundItemId", value = "主键")
    private String groundItemId;
    @ApiModelProperty(name = "groundInfoId", value = "场地")
    private String groundInfoId;
    @ApiModelProperty(name = "groundName", value = "场地名")
    private String groundName;
    @ApiModelProperty(name = "timeStr", value = "开始时间")
    private String timeStr;
    @ApiModelProperty(name = "timeEnd", value = "结束时间")
    private String timeEnd;
    @ApiModelProperty(name = "price", value = "价格")
    private String price;

    public String getGroundItemId() {
        return groundItemId == null ? "" : groundItemId;
    }

    public void setGroundItemId(String groundItemId) {
        this.groundItemId = groundItemId;
    }

    public String getGroundInfoId() {
        return groundInfoId == null ? "" : groundInfoId;
    }

    public void setGroundInfoId(String groundInfoId) {
        this.groundInfoId = groundInfoId;
    }

    public String getTimeStr() {
        return timeStr == null ? "" : timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getTimeEnd() {
        return timeEnd == null ? "" : timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getPrice() {
        return price == null ? "" : price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGroundName() {
        return groundName == null ? "" : groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"groundItemId\":\"")
                .append(groundItemId).append('\"');
        sb.append(",\"groundInfoId\":\"")
                .append(groundInfoId).append('\"');
        sb.append(",\"groundName\":\"")
                .append(groundName).append('\"');
        sb.append(",\"timeStr\":\"")
                .append(timeStr).append('\"');
        sb.append(",\"timeEnd\":\"")
                .append(timeEnd).append('\"');
        sb.append(",\"price\":\"")
                .append(price).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
