package com.cm.venuebooking.dao.groundbooking;

import com.cm.venuebooking.pojo.dtos.bookingorder.GroundTicketDTO;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoOwDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 场馆订单数据层
 * @author xwangs
 * @create 2020-06-04 21:53
 * @description
 */
@Repository
public interface IGroundBookingDao {

    /**
     * 管理人所有场馆列表
     * @param param
     * @return
     */
    List<VenuesInfoOwDTO> listVenuesInfoOw(Map<String, Object> param);


    /**
     * 查询场馆下所有订单
     * @param params
     * @return
     */
    List<GroundTicketDTO> listPageBookingOrder(Map<String, Object> params);
}
