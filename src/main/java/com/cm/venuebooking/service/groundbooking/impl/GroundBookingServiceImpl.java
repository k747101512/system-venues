package com.cm.venuebooking.service.groundbooking.impl;

import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.common.token.app.AppTokenManager;
import com.cm.common.token.app.entity.AppTokenUser;
import com.cm.common.utils.DateUtil;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.pojo.dtos.bookingorder.GroundBookingItemDTO;
import com.cm.venuebooking.pojo.dtos.bookingorder.VenueProjectDTO;
import com.cm.venuebooking.dao.groundbooking.IGroundBookingDao;
import com.cm.venuebooking.pojo.dtos.bookingorder.GroundBookingInfoDTO;
import com.cm.venuebooking.pojo.dtos.bookingorder.MyTicketListDTO;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundItemDTO;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoOwDTO;
import com.cm.venuebooking.pojo.vos.groundbooking.GroundTicketItemVO;
import com.cm.venuebooking.pojo.vos.groundbooking.GroundTicketVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.groundbooking.IGroundBookingService;
import com.cm.venuebooking.service.groundinfo.IGroundInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-06-04 21:49
 * @description
 */
@Service
public class GroundBookingServiceImpl extends BaseService implements IGroundBookingService {

    @Autowired
    private IGroundBookingDao groundBookingDao;

    @Autowired
    private IGroundInfoService groundInfoService;

    @Override
    public SuccessResultList listPageBookingOrder(ListPage page) {
        Map<String, Object> param = page.getParams();
        setDataAuthorityInfo(param);
        String userId = securityComponent.getCurrentUser().getUserId();
        param.put("userId",userId);
        //查询当前用户所管理的场馆
        List<VenuesInfoOwDTO> owList =  groundBookingDao.listVenuesInfoOw(param);
        String venuesInfoIds = "";
        if(owList != null || owList.size() >= 0){
            for(VenuesInfoOwDTO item : owList){
                venuesInfoIds += item.getVenuesInfoId() + ",";
            }
        }
        param.put("venuesInfoIds",venuesInfoIds);
        PageHelper.startPage(page.getPage(), page.getRows());
        List<GroundBookingInfoDTO> list = groundBookingDao.listPageBookingOrder(page.getParams());
        PageInfo<GroundBookingInfoDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList(list, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public SuccessResult saveBookingInfoForApp(String token, GroundTicketVO groundTicketVO) throws Exception{
        AppTokenUser appTokenUser = AppTokenManager.getInstance().getToken(token).getAppTokenUser();
        //预订订单保存
        GroundBookingInfoDTO bookingInfo = new GroundBookingInfoDTO();
        String bookingId = UUIDUtil.getUUID();
        String serial = generateSerialNumber();
        bookingInfo.setGroundBookingId(bookingId);
        bookingInfo.setSerial(serial);
        //查询场馆项目信息
        VenueProjectDTO venueProjectDTO = groundBookingDao.getVenueFromProject(groundTicketVO.getVenuesProjectId());
        bookingInfo.setVenuesInfoId(venueProjectDTO.getVenuesInfoId());
        bookingInfo.setVenuesName(venueProjectDTO.getVenueName());
        bookingInfo.setVenuesProjectId(venueProjectDTO.getVenuesProjectId());
        bookingInfo.setProjectName(venueProjectDTO.getProjectName());
        bookingInfo.setUserId(appTokenUser.getId());
        bookingInfo.setNickName(appTokenUser.getName());
        bookingInfo.setIdCardNumber("");
        bookingInfo.setPhoneNumber("");
        bookingInfo.setOrderType("0");
        Map<String, Object> param = HashMapUtil.beanToMap(bookingInfo);
        setSaveInfo(token,param);

        //保存所选预订项
        List<GroundTicketItemVO> itemList = groundTicketVO.getBookingItemList();
        if(itemList !=null && itemList.size() > 0){
            GroundBookingItemDTO bookingItem = new GroundBookingItemDTO();
            for(GroundTicketItemVO itemInfo : itemList){
                String bookingItemId = UUIDUtil.getUUID();
                bookingItem.setBookingItemId(bookingItemId);
                bookingItem.setBookingInfoId(bookingId);
                bookingItem.setGroundItemId(itemInfo.getGroundItemId());
                bookingItem.setBookingOrderDate(itemInfo.getBookingOrderDate());
                //查询场次时刻信息
                GroundItemDTO groundItemDTO = groundInfoService.getGroundItem(itemInfo.getGroundItemId());
                bookingItem.setGroundName(groundItemDTO.getGroundName());
                bookingItem.setTimeStr(groundItemDTO.getTimeStr());
                bookingItem.setTimeEnd(groundItemDTO.getTimeEnd());
                bookingItem.setPrice(groundItemDTO.getPrice());
                bookingItem.setArriveType("0");
                bookingItem.setOrderType("0");
                Map<String, Object> itemParam = HashMapUtil.beanToMap(bookingItem);
                setSaveInfo(token,itemParam);
                groundBookingDao.saveBookingItem(itemParam);
            }
        }
        groundBookingDao.saveBookingInfo(param);
        return new SuccessResult();
    }

    private String generateSerialNumber(){
        String dateStamp = DateUtil.getDays();
        int randomNum = (int)((Math.random() * 9 + 1) * 100000);
        return dateStamp + randomNum + "";
    }

    @Override
    public SuccessResultList<List<MyTicketListDTO>> listPageMyTicket(String token, ListPage page) {
        AppTokenUser appTokenUser = AppTokenManager.getInstance().getToken(token).getAppTokenUser();
        page.getParams().put("userId",appTokenUser.getId());
        page.getParams().put("nowDateTime",DateUtil.getTime());
        PageHelper.startPage(page.getPage(),page.getRows());
        List<MyTicketListDTO> list = groundBookingDao.listPageMyTicket(page.getParams());
        PageInfo<MyTicketListDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList<>(list,pageInfo.getPageNum(),pageInfo.getTotal());
    }
}
