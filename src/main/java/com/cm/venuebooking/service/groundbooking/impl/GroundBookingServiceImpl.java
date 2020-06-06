package com.cm.venuebooking.service.groundbooking.impl;

import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.dao.groundbooking.IGroundBookingDao;
import com.cm.venuebooking.pojo.dtos.bookingorder.GroundTicketDTO;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoOwDTO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.groundbooking.IGroundBookingService;
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

    @Override
    public SuccessResultList listPageBookingOrder(ListPage page) {
        Map<String, Object> param = page.getParams();
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
        List<GroundTicketDTO> list = groundBookingDao.listPageBookingOrder(page.getParams());
        PageInfo<GroundTicketDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList(list, pageInfo.getPageNum(), pageInfo.getTotal());
    }
}
