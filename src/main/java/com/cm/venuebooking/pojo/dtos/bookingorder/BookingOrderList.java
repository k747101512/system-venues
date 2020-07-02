package com.cm.venuebooking.pojo.dtos.bookingorder;

import io.swagger.annotations.ApiModelProperty;

/**
 * 后台订单列表
 * @author xwangs
 * @create 2020-06-17 17:01
 * @description
 */
public class BookingOrderList {

    @ApiModelProperty(name = "bookingItemId", value = "预订场次ID")
    private String bookingItemId;
    @ApiModelProperty(name = "serial", value = "流水号")
    private String serial;
    @ApiModelProperty(name = "venuesName", value = "场馆名")
    private String venuesName;
    @ApiModelProperty(name = "projectName", value = "项目名")
    private String projectName;
    @ApiModelProperty(name = "groundName", value = "预订场名")
    private String groundName;
    @ApiModelProperty(name = "bookingOrderDate", value = "预订日期")
    private String bookingOrderDate;
    @ApiModelProperty(name = "timeStr", value = "开始时间")
    private String timeStr;
    @ApiModelProperty(name = "timeEnd", value = "结束时间")
    private String timeEnd;
    @ApiModelProperty(name = "price", value = "价格")
    private String price;
    @ApiModelProperty(name = "gmtCreate", value = "创建日期")
    private String gmtCreate;
    @ApiModelProperty(name = "nickName", value = "昵称")
    private String nickName;
    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;

    public String getBookingItemId() {
        return bookingItemId == null ? "" : bookingItemId;
    }

    public void setBookingItemId(String bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public String getSerial() {
        return serial == null ? "" : serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getVenuesName() {
        return venuesName == null ? "" : venuesName;
    }

    public void setVenuesName(String venuesName) {
        this.venuesName = venuesName;
    }

    public String getProjectName() {
        return projectName == null ? "" : projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGroundName() {
        return groundName == null ? "" : groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getBookingOrderDate() {
        return bookingOrderDate == null ? "" : bookingOrderDate;
    }

    public void setBookingOrderDate(String bookingOrderDate) {
        this.bookingOrderDate = bookingOrderDate;
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

    public String getGmtCreate() {
        return gmtCreate == null ? "" : gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getNickName() {
        return nickName == null ? "" : nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"bookingItemId\":\"")
                .append(bookingItemId).append('\"');
        sb.append(",\"serial\":\"")
                .append(serial).append('\"');
        sb.append(",\"venuesName\":\"")
                .append(venuesName).append('\"');
        sb.append(",\"projectName\":\"")
                .append(projectName).append('\"');
        sb.append(",\"groundName\":\"")
                .append(groundName).append('\"');
        sb.append(",\"bookingOrderDate\":\"")
                .append(bookingOrderDate).append('\"');
        sb.append(",\"timeStr\":\"")
                .append(timeStr).append('\"');
        sb.append(",\"timeEnd\":\"")
                .append(timeEnd).append('\"');
        sb.append(",\"price\":\"")
                .append(price).append('\"');
        sb.append(",\"gmtCreate\":\"")
                .append(gmtCreate).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
