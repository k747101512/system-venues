package com.cm.venuebooking.service.register;

import com.cm.common.result.SuccessResult;
import com.cm.venuebooking.pojo.vos.register.RegisterInfoVo;

/**
 * @author xwangs
 * @create 2020-05-21 16:53
 * @description
 */
public interface IRegisterService {

    /**
     * 保存入驻申请信息
     * @param registerInfoVo
     * @return
     */
    SuccessResult saveRegisterInfo(RegisterInfoVo registerInfoVo) throws Exception;
}
