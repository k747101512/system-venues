package com.cm.venuebooking.service.groundbooking;

import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResultList;

/**
 * 场馆订单接口
 * @author xwangs
 * @create 2020-06-04 21:49
 * @description
 */
public interface IGroundBookingService {

    /**
     * 订单分页列表接口
     * @param page
     * @return
     */
    SuccessResultList listPageBookingOrder(ListPage page);
}
