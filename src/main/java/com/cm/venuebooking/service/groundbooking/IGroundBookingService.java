package com.cm.venuebooking.service.groundbooking;

import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.bookingorder.MyTicketListDTO;
import com.cm.venuebooking.pojo.vos.groundbooking.GroundTicketVO;

import java.util.List;

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

    /**
     * 小程序保存订单信息
     * @param token
     * @param groundTicketVO
     * @return
     */
    SuccessResult saveBookingInfoForApp(String token, GroundTicketVO groundTicketVO) throws Exception;

    /**
     * 查询我的订单列表
     * @param token
     * @param page
     * @return
     */
    SuccessResultList<List<MyTicketListDTO>> listPageMyTicket(String token, ListPage page);
}
