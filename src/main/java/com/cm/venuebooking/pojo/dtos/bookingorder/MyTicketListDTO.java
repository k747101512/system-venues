package com.cm.venuebooking.pojo.dtos.bookingorder;

import io.swagger.annotations.ApiModelProperty;

/**
 * 预订订单信息
 * @author xwangs
 * @create 2020-06-08 16:44
 * @description
 */
public class MyTicketListDTO {

    @ApiModelProperty(name = "serial", value = "流水号")
    private String serial;
    @ApiModelProperty(name = "bookingDate", value = "预订日期")
    private String bookingDate;
    @ApiModelProperty(name = "venueName", value = "场馆名称")
    private String venueName;
    @ApiModelProperty(name = "price", value = "金额")
    private String price;

    public String getSerial() {
        return serial == null ? "" : serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getBookingDate() {
        return bookingDate == null ? "" : bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getVenueName() {
        return venueName == null ? "" : venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getPrice() {
        return price == null ? "" : price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"serial\":\"")
                .append(serial).append('\"');
        sb.append(",\"bookingDate\":\"")
                .append(bookingDate).append('\"');
        sb.append(",\"venueName\":\"")
                .append(venueName).append('\"');
        sb.append(",\"price\":\"")
                .append(price).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
