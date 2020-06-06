package com.cm.venuebooking.dao.register;

import org.springframework.stereotype.Repository;

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
}
