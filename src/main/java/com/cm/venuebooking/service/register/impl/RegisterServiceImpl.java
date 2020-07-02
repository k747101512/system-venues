package com.cm.venuebooking.service.register.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cm.common.config.properties.ApiPathProperties;
import com.cm.common.plugin.IApiConsts;
import com.cm.common.plugin.utils.RestTemplateUtil;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.common.token.app.AppTokenManager;
import com.cm.common.token.app.entity.AppTokenUser;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.register.IRegisterDao;
import com.cm.venuebooking.pojo.dtos.register.BindUserDTO;
import com.cm.venuebooking.pojo.dtos.register.RegisterInfoDTO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.register.IRegisterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private ApiPathProperties apiPathProperties;

    @Override
    public SuccessResult saveRegisterInfo(String token, RegisterInfoDTO registerInfoDTO) throws Exception {
        Map<String,Object> params = HashMapUtil.beanToMap(registerInfoDTO);
        params.put("registerId", UUIDUtil.getUUID());
        params.put("userId", "");
        params.put("passType", "0");
        setSaveInfo(token,params);
        registerDao.saveRegisterInfo(params);
        return new SuccessResult();
    }

    @Override
    public SuccessResultList listPageVenuesRegister(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<RegisterInfoDTO> list = registerDao.listPageVenuesRegister(page.getParams());
        PageInfo<RegisterInfoDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList(list, pageInfo.getPageNum(), pageInfo.getTotal());
    }

    @Override
    public SuccessResult removeRegister(String id) {
        Map<String,Object> params = getHashMap(4);
        params.put("registerId",id);
        registerDao.removeRegister(params);
        return new SuccessResult();
    }

    @Override
    public RegisterInfoDTO getRegisterInfo(String id) {
        Map<String, Object> param = getHashMap(4);
        param.put("registerId",id);
        return registerDao.getRegisterInfo(param);
    }

    @Override
    public SuccessResultData getUnbindRegisterUser() {
        String result = restTemplateUtil.doPostForm(String.format(IApiConsts.LIST_ALL_USER, apiPathProperties.getUserCenter()), getHashMap(2));
        JSONArray array = JSONArray.parseArray(result);
        List<BindUserDTO> userList = new ArrayList<>();
        for (int i=0; i<array.size();i++) {
            JSONObject item = array.getJSONObject(i);
            String userType = StringUtils.isEmpty(item.get("userType")) ? "0" : item.get("userType").toString();
            if ("1".equals(userType)) {
                BindUserDTO user = new BindUserDTO();
                user.setUserId(item.get("userId").toString());
                user.setName(item.get("userName").toString());
                user.setLoginName(item.get("userUsername").toString());
                userList.add(user);
            }
        }
        return new SuccessResultData(userList);
    }

    @Override
    public SuccessResult updateRegisterInfo(RegisterInfoDTO registerInfoDTO) throws Exception{
        Map<String,Object> param = HashMapUtil.beanToMap(registerInfoDTO);
        setUpdateInfo(param);
        registerDao.updateRegisterInfo(param);
        return new SuccessResult();
    }

    @Override
    public SuccessResultData getRegisterInfoForApp(String token) {
        AppTokenUser appTokenUser = AppTokenManager.getInstance().getToken(token).getAppTokenUser();
        Map<String, Object> param = getHashMap(4);
        param.put("creator",appTokenUser.getId());
        RegisterInfoDTO registerInfoDTO = registerDao.getRegisterInfo(param);
        registerInfoDTO = registerInfoDTO == null ? new RegisterInfoDTO() : registerInfoDTO;
        return new SuccessResultData(registerInfoDTO);
    }

    @Override
    public SuccessResult updateRegisterInfoForApp(String token, RegisterInfoDTO infoDTO) throws Exception {
        Map<String,Object> param = HashMapUtil.beanToMap(infoDTO);
        param.put("passType","0");
        param.put("reason","");
        registerDao.updateRegisterInfo(param);
        return new SuccessResult();
    }
}
