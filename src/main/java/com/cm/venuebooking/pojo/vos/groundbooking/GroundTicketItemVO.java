package com.cm.venuebooking.pojo.vos.groundbooking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预订订单实体类
 * @author xwangs
 * @create 2020-05-13 10:30
 * @description
 */
@ApiModel
public class GroundTicketItemVO {

    @ApiModelProperty(name = "bookingOrderDate", value = "预订日期")
    private String bookingOrderDate;
    @ApiModelProperty(name = "groundItemId", value = "所选场次时刻ID")
    private String groundItemId;

    public String getBookingOrderDate() {
        return bookingOrderDate == null ? "" : bookingOrderDate;
    }

    public void setBookingOrderDate(String bookingOrderDate) {
        this.bookingOrderDate = bookingOrderDate;
    }

    public String getGroundItemId() {
        return groundItemId == null ? "" : groundItemId;
    }

    public void setGroundItemId(String groundItemId) {
        this.groundItemId = groundItemId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"bookingOrderDate\":\"")
                .append(bookingOrderDate).append('\"');
        sb.append(",\"groundItemId\":\"")
                .append(groundItemId).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
