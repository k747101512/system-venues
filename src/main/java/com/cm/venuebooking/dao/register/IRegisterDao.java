package com.cm.venuebooking.dao.register;

import com.cm.venuebooking.pojo.dtos.register.RegisterInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-21 16:57
 * @description
 */
@Repository
public interface IRegisterDao {

    /**
     * 保存入驻申请信息
     * @param params
     */
    void saveRegisterInfo(Map<String, Object> params);

    /**
     * 场馆入驻分页列表
     * @param params
     * @return
     */
    List<RegisterInfoDTO> listPageVenuesRegister(Map<String, Object> params);

    /**
     * 删除入驻信息
     * @param params
     */
    void removeRegister(Map<String, Object> params);

    /**
     * 入驻信息详情
     * @param param
     * @return
     */
    RegisterInfoDTO getRegisterInfo(Map<String, Object> param);

    /**
     * 查询已经绑定场馆的用户
     * @return
     */
    List<Map<String,String>> listVenueOw();

    /**
     * 审核入驻信息
     * @param map
     */
    void updateRegisterInfo(Map<String, Object> map);
}
