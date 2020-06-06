package com.cm.venuebooking.dao.venuesinfo;

import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.exception.UpdateException;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.venuesinfo.VenuesInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IVenuesInfoDao
 * @Description: 场馆信息表
 * @Author: WenG
 * @Date: 2020-04-22 11:46
 * @Version: 1.0
 **/
@Repository
public interface IVenuesInfoDao {

    /**
     * 新增场馆信息表
     *
     * @param params
     * @throws SaveException
     */
    void saveVenuesInfo(Map<String, Object> params) throws SaveException;

    /**
     * 删除场馆信息表
     *
     * @param params
     * @throws RemoveException
     */
    void removeVenuesInfo(Map<String, Object> params) throws RemoveException;

    /**
     * 修改场馆信息表
     *
     * @param params
     * @throws UpdateException
     */
    void updateVenuesInfo(Map<String, Object> params) throws UpdateException;

    /**
     * 场馆信息表详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    VenuesInfoDTO getVenuesInfo(Map<String, Object> params) throws SearchException;

    /**
     * 场馆信息表列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<VenuesInfoDTO> listVenuesInfo(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-根据项目类别查询场馆
     * @param params
     * @return
     */
    List<VenuesInfoDTO> listVenuesByKeyWords(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-查询场馆详情
     * @param params
     * @return
     * @throws SearchException
     */
    VenuesInfoDTO getVenuesInfoDetailForMiniApp(Map<String, Object> params) throws SearchException;

    Object getCityInfoByName(Map<String, Object> param) throws SearchException;

    /**
     * 保存场馆和管理人关系表
     * @param params
     */
    void saveVenueOwner(Map<String, Object> params);
}
