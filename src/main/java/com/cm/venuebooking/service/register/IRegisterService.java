package com.cm.venuebooking.service.register;

import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.register.RegisterInfoDTO;

/**
 * @author xwangs
 * @create 2020-05-21 16:53
 * @description
 */
public interface IRegisterService {

    /**
     * 保存入驻申请信息
     * @param token
     * @param infoDTO
     * @return
     * @throws Exception
     */
    SuccessResult saveRegisterInfo(String token, RegisterInfoDTO infoDTO) throws Exception;

    /**
     * 入驻信息列表
     * @param page
     * @return
     */
    SuccessResultList listPageVenuesRegister(ListPage page);

    /**
     * 删除入驻信息
     * @param id
     * @return
     */
    SuccessResult removeRegister(String id);

    /**
     * 入驻信息详情
     * @param id
     * @return
     */
    RegisterInfoDTO getRegisterInfo(String id);

    /**
     * 获取未绑定的用户列表
     * @return
     */
    SuccessResultData getUnbindRegisterUser();

    /**
     * 保存入驻信息审核
     * @param registerInfoDTO
     * @return
     * @throws Exception
     */
    SuccessResult updateRegisterInfo(RegisterInfoDTO registerInfoDTO) throws Exception;

    /**
     * 入驻信息详情
     * @param token
     * @return
     */
    SuccessResultData getRegisterInfoForApp(String token);

    /**
     * 更新入驻信息-app
     * @param token
     * @param infoDTO
     * @return
     */
    SuccessResult updateRegisterInfoForApp(String token, RegisterInfoDTO infoDTO) throws Exception;
}
