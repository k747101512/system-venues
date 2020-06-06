package com.cm.venuebooking.service.groundinfo.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cm.common.exception.SaveException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.groundinfo.IGroundInfoDao;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundInfoDTO;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundItemDTO;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoDTO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.groundinfo.IGroundInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 场地场次实现类
 * @author xwangs
 * @create 2020-06-01 20:56
 * @description
 */
@Service
public class GroundInfoServiceImpl extends BaseService implements IGroundInfoService {

    @Autowired
    private IGroundInfoDao groundInfoDao;

    @Override
    public SuccessResult saveGroundInfo(JSONObject obj) throws SaveException {
        Map<String, Object> param = getHashMap(8);
        String groundInfoId = UUIDUtil.getUUID();
        String venuesInfoId = obj.getString("venuesInfoId");
        String venuesProjectId = obj.getString("venuesProjectId");
        String groundName = obj.getString("groundName");
        String groundLocation = obj.getString("groundLocation");
        String openCloseType = "open";
        param.put("groundInfoId",groundInfoId);
        param.put("venuesInfoId",venuesInfoId);
        param.put("venuesProjectId",venuesProjectId);
        param.put("groundName",groundName);
        param.put("groundLocation",groundLocation);
        param.put("openCloseType",openCloseType);
        setSaveInfo(param);
        //保存场地
        groundInfoDao.saveGroundInfo(param);
        //保存场次
        JSONArray itemList = obj.getJSONArray("itemList");
        if(itemList != null && itemList.size() > 0){
            for(int i = 0; i < itemList.size(); i++){
                JSONObject itemObj = itemList.getJSONObject(i);
                param.put("groundItemId",UUIDUtil.getUUID());
                param.put("timeStr",itemObj.getString("timeStr"));
                param.put("timeEnd",itemObj.getString("timeEnd"));
                param.put("price",itemObj.getString("price"));
                groundInfoDao.saveGroundItem(param);
            }
        }
        return new SuccessResult();
    }

    @Override
    public SuccessResultData getGroundInfo(String groundInfoId) {
        Map<String, Object> param = getHashMap(2);
        param.put("groundInfoId",groundInfoId);
        GroundInfoDTO groundInfoDTO = groundInfoDao.getGroundInfo(param);
        //场次列表
        List<GroundItemDTO> itemList = groundInfoDao.listGroundItem(param);
        Map<String, Object> result = getHashMap(16);
        result.put("groundInfo",groundInfoDTO);
        result.put("itemList",itemList);
        return new SuccessResultData(result);
    }

    @Override
    public SuccessResult updateGroundInfo(JSONObject jsonObject) {
        Map<String, Object> param = getHashMap(8);
        String groundInfoId = jsonObject.getString("groundInfoId");
        String groundName = jsonObject.getString("groundName");
        String groundLocation = jsonObject.getString("groundLocation");
        param.put("groundInfoId",groundInfoId);
        param.put("groundName",groundName);
        param.put("groundLocation",groundLocation);
        setUpdateInfo(param);
        //更新场地
        groundInfoDao.updateGroundInfo(param);
        //更新场次
        JSONArray itemList = jsonObject.getJSONArray("itemList");
        if(itemList != null && itemList.size() > 0){
            for(int i = 0; i < itemList.size(); i++){
                JSONObject itemObj = itemList.getJSONObject(i);
                param.put("timeStr",itemObj.getString("timeStr"));
                param.put("timeEnd",itemObj.getString("timeEnd"));
                param.put("price",itemObj.getString("price"));
                if(StringUtils.isEmpty(itemObj.get("groundItemId"))){
                    param.put("groundItemId",UUIDUtil.getUUID());
                    groundInfoDao.saveGroundItem(param);
                } else {
                    param.put("groundItemId",itemObj.getString("groundItemId"));
                    groundInfoDao.updateGroundItem(param);
                }
            }
        }
        return new SuccessResult();
    }

    @Override
    public SuccessResult updateOpenCloseType(Map<String, Object> param) {
        setUpdateInfo(param);
        groundInfoDao.updateGroundInfo(param);
        return new SuccessResult();
    }

    @Override
    public SuccessResultList listPageGroundInfo(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<GroundInfoDTO> list = groundInfoDao.listPageGroundInfo(page.getParams());
        PageInfo<GroundInfoDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList(list,pageInfo.getPageNum(),pageInfo.getTotal());
    }

    @Override
    public List<GroundInfoDTO> listGroundInfo(Map<String, Object> param) {
        return groundInfoDao.listGroundInfo(param);
    }

    @Override
    public void removeGroundInfo(String ids) {
        Map<String, Object> params = getHashMap(2);
        params.put("groundInfoIds", Arrays.asList(ids.split("_")));
        setUpdateInfo(params);
        groundInfoDao.removeGroundInfo(params);
    }

    @Override
    public SuccessResultData listGroundInfoMiniApp(Map<String, Object> params) {
        //查询场地
        List<GroundInfoDTO> groundInfoList = groundInfoDao.listGroundInfo(params);
        //查询场次
        if(groundInfoList != null && groundInfoList.size() > 0){
            for(GroundInfoDTO info : groundInfoList ){
                params.put("groundInfoId",info.getGroundInfoId());
                List<GroundItemDTO> itemList = groundInfoDao.listGroundItem(params);
                info.setGroundItemList(itemList != null ? itemList : new ArrayList<>(0));
            }
        }
        return new SuccessResultData(groundInfoList);
    }
}
