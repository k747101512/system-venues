package com.cm.venuebooking.service.venuesinfo.impl;

import com.cm.common.component.SecurityComponent;
import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.pojo.bos.UserInfoBO;
import com.cm.common.pojo.dtos.ZTreeDTO;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.DateUtil;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.common.utils.point.Point;
import com.cm.venuebooking.dao.venuesinfo.IVenuesInfoDao;
import com.cm.venuebooking.dao.venuesproject.IVenuesProjectDao;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoDTO;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectDTO;
import com.cm.venuebooking.pojo.vos.venuesinfo.VenuesInfoVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.venuesinfo.IVenuesInfoService;
import com.cm.venuebooking.utils.MapLocationTransformUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: VenuesInfoServiceImpl
 * @Description: 场馆信息表
 * @Author: WenG
 * @Date: 2020-04-22 11:46
 * @Version: 1.0
 **/
@Service
public class VenuesInfoServiceImpl extends BaseService implements IVenuesInfoService {

    @Autowired
    private IVenuesInfoDao venuesInfoDao;

    @Autowired
    private IVenuesProjectDao venuesProjectDao;

    @Autowired
    private SecurityComponent securityComponent;

    @Override
    public SuccessResult saveVenuesInfo(VenuesInfoVO venuesInfoVO) throws Exception {
        saveVenuesInfoInfo(null, venuesInfoVO);
        return new SuccessResult();
    }

    @Override
    public SuccessResult saveVenuesInfoByToken(String token, VenuesInfoVO venuesInfoVO) throws Exception {
        saveVenuesInfoInfo(token, venuesInfoVO);
        return new SuccessResult();
    }

    /**
     * 新增场馆信息表
     *
     * @param token
     * @param venuesInfoVO
     * @throws Exception
     */
    private void saveVenuesInfoInfo(String token, VenuesInfoVO venuesInfoVO) throws Exception {
        Map<String, Object> params = HashMapUtil.beanToMap(venuesInfoVO);
        params.put("venuesInfoId", UUIDUtil.getUUID());
        if (token != null) {
            setSaveInfo(token, params);
        } else {
            setSaveInfo(params);
        }
        venuesInfoDao.saveVenuesInfo(params);
        UserInfoBO userInfoBO = securityComponent.getCurrentUser();
        params.put("owId",UUIDUtil.getUUID());
        params.put("userName",userInfoBO.getUserName());
        venuesInfoDao.saveVenueOwner(params);

    }

    @Override
    public SuccessResult removeVenuesInfo(String ids) throws RemoveException {
        removeVenuesInfoInfo(null, ids);
        return new SuccessResult();
    }

    @Override
    public SuccessResult removeVenuesInfoByToken(String token, String ids) throws RemoveException {
        removeVenuesInfoInfo(token, ids);
        return new SuccessResult();
    }

    /**
     * 删除场馆信息表
     *
     * @param token
     * @param ids
     */
    private void removeVenuesInfoInfo(String token, String ids) {
        Map<String, Object> params = getHashMap(3);
        params.put("venuesInfoIds", Arrays.asList(ids.split("_")));
        if (token != null) {
            setUpdateInfo(token, params);
        } else {
            setUpdateInfo(params);
        }
        venuesInfoDao.removeVenuesInfo(params);
    }

    @Override
    public SuccessResult updateVenuesInfo(String venuesInfoId, VenuesInfoVO venuesInfoVO) throws Exception {
        updateVenuesInfoInfo(null, venuesInfoId, venuesInfoVO);
        return new SuccessResult();
    }

    @Override
    public SuccessResult updateVenuesInfoByToken(String token, String venuesInfoId, VenuesInfoVO venuesInfoVO) throws Exception {
        updateVenuesInfoInfo(token, venuesInfoId, venuesInfoVO);
        return new SuccessResult();
    }

    /**
     * 修改场馆信息表
     *
     * @param token
     * @param venuesInfoId
     * @param venuesInfoVO
     */
    private void updateVenuesInfoInfo(String token, String venuesInfoId, VenuesInfoVO venuesInfoVO) throws Exception {
        Map<String, Object> params = HashMapUtil.beanToMap(venuesInfoVO);
        params.put("venuesInfoId", venuesInfoId);
        if (token != null) {
            setUpdateInfo(token, params);
        } else {
            setUpdateInfo(params);
        }
        venuesInfoDao.updateVenuesInfo(params);
    }

    @Override
    public VenuesInfoDTO getVenuesInfoById(String venuesInfoId) throws SearchException {
        Map<String, Object> params = super.getHashMap(1);
        params.put("venuesInfoId", venuesInfoId);
        return venuesInfoDao.getVenuesInfo(params);
    }

    @Override
    public List<VenuesInfoDTO> listVenuesInfo(Map<String, Object> params) throws SearchException {
        setDataAuthorityInfo(params);
        params.put("creator",securityComponent.getCurrentUser().getUserId());
        return venuesInfoDao.listVenuesInfo(params);
    }

    @Override
    public List<ZTreeDTO> listVenuesInfoZTree() {
        Map<String, Object> params = getHashMap(16);
        setDataAuthorityInfo(params);
        params.put("creator",securityComponent.getCurrentUser().getUserId());
        List<VenuesInfoDTO> venuesInfoDTO = venuesInfoDao.listVenuesInfo(params);
        List<ZTreeDTO> zTreeDTOs = new ArrayList<>();
        for (VenuesInfoDTO item : venuesInfoDTO){
            ZTreeDTO zTreeDTO = new ZTreeDTO();
            zTreeDTO.setName(item.getVenueName());
            zTreeDTO.setpId("0");
            zTreeDTO.setId(item.getVenuesInfoId());
            zTreeDTOs.add(zTreeDTO);
        }
        return zTreeDTOs;
    }

    @Override
    public SuccessResultList<List<VenuesInfoDTO>> listPageVenuesInfo(ListPage page) throws SearchException {
        setDataAuthorityInfo(page.getParams());
        page.getParams().put("creator",securityComponent.getCurrentUser().getUserId());
        PageHelper.startPage(page.getPage(), page.getRows());
        List<VenuesInfoDTO> venuesInfoDTOs = venuesInfoDao.listVenuesInfo(page.getParams());
        PageInfo<VenuesInfoDTO> pageInfo = new PageInfo<>(venuesInfoDTOs);
        return new SuccessResultList<>(venuesInfoDTOs, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public SuccessResultData listVenuesByKeyWords(String token, Map<String, Object> params) throws SearchException {
        String projectCategory = StringUtils.isEmpty(params.get("categoryId")) ? "" : params.get("categoryId").toString();
        String venueCity = StringUtils.isEmpty(params.get("cityId")) ? "" : params.get("cityId").toString();
        String venueArea = StringUtils.isEmpty(params.get("areaId")) ? "" : params.get("areaId").toString();
        params.put("projectCategory",projectCategory);
        params.put("venueCity",venueCity);
        params.put("venueArea",venueArea);
        List<VenuesInfoDTO> list = venuesInfoDao.listVenuesByKeyWords(params);
        for (VenuesInfoDTO item : list){
            item.setVenuePanorama(item.getVenuePanorama().split(",")[0]);
        }
        return new SuccessResultData(list);
    }

    @Override
    public SuccessResultData getVenuesDetailById(Map<String, Object> params) throws SearchException {
        VenuesInfoDTO venuesInfoDTO = venuesInfoDao.getVenuesInfoDetailForMiniApp(params);
        Point point = new Point();
        MapLocationTransformUtil util = new MapLocationTransformUtil();
        point.setX(Double.parseDouble(venuesInfoDTO.getLatitude()));
        point.setY(Double.parseDouble(venuesInfoDTO.getLongitude()));
        point = util.map_bd2tx(point);
        venuesInfoDTO.setLatitude(point.getX() + "");
        venuesInfoDTO.setLongitude(point.getY() + "");
        return new SuccessResultData(venuesInfoDTO);
    }

    @Override
    public Map<String, Object> getVenuesProjectDetailById(String token, Map<String, Object> params) {
        Map<String,Object> result = getHashMap(0);
        if(StringUtils.isEmpty(params.get("venuesProjectId"))){
            return result;
        }
        VenuesProjectDTO venuesProjectDTO = venuesProjectDao.getVenuesProjectDetailById(params);
        result.put("venuesProjectInfo",venuesProjectDTO);
        //返回近三天的预定状态
        List<Map<String, Object>> dayList = new ArrayList<>(0);
        SimpleDateFormat sf = new SimpleDateFormat("M月d日");
        String[] dayGroup = new String[]{DateUtil.getTime(),DateUtil.getAfterDayDate("1"),DateUtil.getAfterDayDate("2")};
        for (int i = 0; i < dayGroup.length;i++) {
            Map<String, Object> dayMap = getHashMap(0);
            dayMap.put("week",DateUtil.getAfterDayWeek(i + ""));
            dayMap.put("dateFormat",sf.format(DateUtil.fomatDate(dayGroup[i])));
            dayMap.put("date",dayGroup[i].substring(0,10));
            //判断是否可以预订
            dayMap.put("bookingType","true");
            if(i == 0){
                dayMap.put("week","今天");
            }
            dayList.add(dayMap);
        }
        result.put("dayList",dayList);
        return result;
    }



    @Override
    public Object getCityInfoByName(Map<String, Object> param) throws SearchException {
        String cityName = StringUtils.isEmpty(param.get("cityName")) ? "" :  param.get("cityName").toString();
        param.put("cityName",cityName);
        return venuesInfoDao.getCityInfoByName(param);
    }
}
