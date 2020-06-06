package com.cm.venuebooking.pojo.dtos.bookingorder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-13 10:30
 * @description
 */
@ApiModel
public class GroundTicketDTO {

    @ApiModelProperty(name = "groundBookingId", value = "预订表主键")
    private String groundBookingId;
    @ApiModelProperty(name = "groundInfoId", value = "场地主键")
    private String groundInfoId;
    @ApiModelProperty(name = "userName", value = "预订人")
    private String userName;
    @ApiModelProperty(name = "idCardNumber", value = "身份证号")
    private String idCardNumber;
    @ApiModelProperty(name = "phoneNumber", value = "联系电话")
    private String phoneNumber;
    @ApiModelProperty(name = "bookingOrderDate", value = "预订日期")
    private String bookingOrderDate;
    @ApiModelProperty(name = "arriveType", value = "到场状态")
    private String arriveType;
    @ApiModelProperty(name = "cancel", value = "取消状态")
    private String cancel;

    public String getGroundBookingId() {
        return groundBookingId == null ? "" : groundBookingId;
    }

    public void setGroundBookingId(String groundBookingId) {
        this.groundBookingId = groundBookingId;
    }

    public String getGroundInfoId() {
        return groundInfoId == null ? "" : groundInfoId;
    }

    public void setGroundInfoId(String groundInfoId) {
        this.groundInfoId = groundInfoId;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBookingOrderDate() {
        return bookingOrderDate == null ? "" : bookingOrderDate;
    }

    public void setBookingOrderDate(String bookingOrderDate) {
        this.bookingOrderDate = bookingOrderDate;
    }

    public String getArriveType() {
        return arriveType == null ? "" : arriveType;
    }

    public void setArriveType(String arriveType) {
        this.arriveType = arriveType;
    }

    public String getCancel() {
        return cancel == null ? "" : cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"groundBookingId\":\"")
                .append(groundBookingId).append('\"');
        sb.append(",\"groundInfoId\":\"")
                .append(groundInfoId).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"idCardNumber\":\"")
                .append(idCardNumber).append('\"');
        sb.append(",\"phoneNumber\":\"")
                .append(phoneNumber).append('\"');
        sb.append(",\"bookingOrderDate\":\"")
                .append(bookingOrderDate).append('\"');
        sb.append(",\"arriveType\":\"")
                .append(arriveType).append('\"');
        sb.append(",\"cancel\":\"")
                .append(cancel).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
