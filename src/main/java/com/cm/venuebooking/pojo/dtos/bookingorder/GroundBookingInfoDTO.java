package com.cm.venuebooking.pojo.dtos.bookingorder;

import io.swagger.annotations.ApiModelProperty;

/**
 * 预订订单信息
 * @author xwangs
 * @create 2020-06-08 16:44
 * @description
 */
public class GroundBookingInfoDTO {

    @ApiModelProperty(name = "groundBookingId", value = "预订表主键")
    private String groundBookingId;
    @ApiModelProperty(name = "serial", value = "流水号")
    private String serial;
    @ApiModelProperty(name = "venuesInfoId", value = "场馆ID")
    private String venuesInfoId;
    @ApiModelProperty(name = "venuesName", value = "场馆名")
    private String venuesName;
    @ApiModelProperty(name = "venuesProjectId", value = "项目ID")
    private String venuesProjectId;
    @ApiModelProperty(name = "projectName", value = "项目")
    private String projectName;
    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;
    @ApiModelProperty(name = "nickName", value = "预订人姓名")
    private String nickName;
    @ApiModelProperty(name = "idCardNumber", value = "身份证号")
    private String idCardNumber;
    @ApiModelProperty(name = "phoneNumber", value = "手机号")
    private String phoneNumber;
    @ApiModelProperty(name = "orderType", value = "订单状态0正常1取消2过期")
    private String orderType;
    /*@ApiModelProperty(name = "arriveType", value = "到场情况-未到0已到1协商2拉黑")
    private String arriveType;*/
    /*@ApiModelProperty(name = "reason", value = "已协商或拉黑理由")
    private String reason;*/

    public String getGroundBookingId() {
        return groundBookingId == null ? "" : groundBookingId;
    }

    public void setGroundBookingId(String groundBookingId) {
        this.groundBookingId = groundBookingId;
    }

    public String getSerial() {
        return serial == null ? "" : serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVenuesInfoId() {
        return venuesInfoId == null ? "" : venuesInfoId;
    }

    public void setVenuesInfoId(String venuesInfoId) {
        this.venuesInfoId = venuesInfoId;
    }

    public String getVenuesName() {
        return venuesName == null ? "" : venuesName;
    }

    public void setVenuesName(String venuesName) {
        this.venuesName = venuesName;
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

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName == null ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdCardNumber() {
        return idCardNumber == null ? "" : idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber == null ? "" : phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderType() {
        return orderType == null ? "" : orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"groundBookingId\":\"")
                .append(groundBookingId).append('\"');
        sb.append(",\"serial\":\"")
                .append(serial).append('\"');
        sb.append(",\"venuesInfoId\":\"")
                .append(venuesInfoId).append('\"');
        sb.append(",\"venuesName\":\"")
                .append(venuesName).append('\"');
        sb.append(",\"venuesProjectId\":\"")
                .append(venuesProjectId).append('\"');
        sb.append(",\"projectName\":\"")
                .append(projectName).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"idCardNumber\":\"")
                .append(idCardNumber).append('\"');
        sb.append(",\"phoneNumber\":\"")
                .append(phoneNumber).append('\"');
        sb.append(",\"orderType\":\"")
                .append(orderType).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
