package com.cm.venuebooking.service.register.impl;

import com.cm.common.result.SuccessResult;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.register.IRegisterDao;
import com.cm.venuebooking.pojo.vos.register.RegisterInfoVo;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.register.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-21 16:54
 * @description
 */
@Service
public class RegisterServiceImpl extends BaseService implements IRegisterService {

    @Autowired
    private IRegisterDao registerDao;

    @Override
    public SuccessResult saveRegisterInfo(RegisterInfoVo registerInfoVo) throws Exception {
        Map<String,Object> params = HashMapUtil.beanToMap(registerInfoVo);
        params.put("registerId", UUIDUtil.getUUID());
        registerDao.saveRegisterInfo(params);
        return new SuccessResult();
    }
}
