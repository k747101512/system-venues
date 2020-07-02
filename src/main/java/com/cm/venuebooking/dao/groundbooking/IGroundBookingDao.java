package com.cm.venuebooking.dao.groundbooking;

import com.cm.venuebooking.pojo.dtos.bookingorder.VenueProjectDTO;
import com.cm.venuebooking.pojo.dtos.bookingorder.GroundBookingInfoDTO;
import com.cm.venuebooking.pojo.dtos.bookingorder.MyTicketListDTO;
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
    List<GroundBookingInfoDTO> listPageBookingOrder(Map<String, Object> params);

    /**
     * 小程序保存订单
     * @param param
     */
    void saveBookingInfo(Map<String, Object> param);

    /**
     * 查询我的订单列表
     * @param params
     * @return
     */
    List<MyTicketListDTO> listPageMyTicket(Map<String, Object> params);

    /**
     * 场馆项目场地信息
     * @param venuesProjectId 项目主键
     * @return
     */
    VenueProjectDTO getVenueFromProject(String venuesProjectId);

    /**
     * 保存预订项记录
     * @param param
     */
    void saveBookingItem(Map<String, Object> param);
}
