package com.cm.venuebooking.service.groundinfo;

import com.alibaba.fastjson.JSONObject;
import com.cm.common.exception.SaveException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundInfoDTO;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundItemDTO;

import java.util.List;
import java.util.Map;

/**
 * 场地场次接口
 * @author xwangs
 * @create 2020-06-01 20:54
 * @description
 */
public interface IGroundInfoService {

    /**
     * 保存场地和场次信息
     * @param jsonObject
     * @return
     * @throws SaveException
     */
    SuccessResult saveGroundInfo(JSONObject jsonObject) throws SaveException;

    /**
     * 单查场地和场次信息
     * @param groundInfoId
     * @return
     */
    SuccessResult getGroundInfo(String groundInfoId);

    /**
     * 修改场地及场次
     * @param jsonObject
     * @return
     */
    SuccessResult updateGroundInfo(JSONObject jsonObject);

    /**
     * 场地分页列表
     * @param page
     * @return
     */
    SuccessResultList listPageGroundInfo(ListPage page);

    /**
     * 删除场地
     * @param ids
     */
    void removeGroundInfo(String ids);

    /**
     * 更改场地开关状态
     * @param param
     * @return
     */
    SuccessResult updateOpenCloseType(Map<String, Object> param);

    /**
     * 场地列表
     * @param param
     * @return
     */
    List<GroundInfoDTO> listGroundInfo(Map<String, Object> param);

    /**
     * 场地场次列表
     * @param params
     * @return
     */
    SuccessResultData listGroundInfoMiniApp(Map<String, Object> params);

    /**
     * 查询场次时刻(单条)
     * @param groundItemId
     * @return
     */
    GroundItemDTO getGroundItem(String groundItemId);

    /**
     * 查询场地信息(byId)
     * @param groundInfoId
     * @return
     */
    GroundInfoDTO getGroundInfoById(String groundInfoId);
}
