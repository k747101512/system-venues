package com.cm.venuebooking.service.venuedictionary.impl;

import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.plugin.dao.datadictionary.IDataDictionaryDao;
import com.cm.common.plugin.pojo.dtos.datadictionary.DataDictionaryDTO;
import com.cm.common.plugin.service.datadictionary.impl.DataDictionaryServiceImpl;
import com.cm.common.result.SuccessResult;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.venuedictionary.IVenueDictionaryDao;
import com.cm.venuebooking.pojo.dtos.venuedictionary.VenueDictionaryDTO;
import com.cm.venuebooking.pojo.vos.venuedictionary.VenueDictionaryVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.venuedictionary.IVenueDictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-27 14:25
 * @description
 */
@Service
public class VenueDictionaryServiceImpl extends BaseService implements IVenueDictionaryService {

    @Autowired
    private IVenueDictionaryDao venueDictionaryDao;
    @Autowired
    private IDataDictionaryDao dictionaryDao;
    @Autowired
    private DataDictionaryServiceImpl dataDictionaryService;

    @Override
    public SuccessResult save(VenueDictionaryVO venueDictionaryVO) throws Exception{
        String uuid = UUIDUtil.getUUID();
        String parentCode = null;
        String dictionaryParentId = venueDictionaryVO.getDictionaryParentId();
        if (!StringUtils.equals(dictionaryParentId, ISystemConstant.TREE_BASE_ROOT_ID_VALUE)) {
            DataDictionaryDTO dictionaryDTO = dataDictionaryService.getDictionaryById(dictionaryParentId);
            parentCode = dictionaryDTO.getDictionaryCode();
        }
        String dictionaryCode = getCode(parentCode, dictionaryParentId);
        Map<String, Object> params = HashMapUtil.beanToMap(venueDictionaryVO);
        params.put("dictionaryCode", dictionaryCode);
        params.put("dictionaryId", uuid);
        setSaveInfo(params);
        venueDictionaryDao.save(params);
        return new SuccessResult();
    }

    @Override
    public VenueDictionaryDTO getVenueDictionaryById(String dictionaryId) {
        Map<String, Object> params = getHashMap(1);
        params.put("dictionaryId", dictionaryId);
        return venueDictionaryDao.getVenueDictionary(params);
    }

    @Override
    public SuccessResult update(String dictionaryId, VenueDictionaryDTO venueDictionaryDTO) throws Exception{
        Map<String, Object> params = HashMapUtil.beanToMap(venueDictionaryDTO);
        params.put("dictionaryId", dictionaryId);
        setUpdateInfo(params);
        venueDictionaryDao.update(params);
        return new SuccessResult();
    }

    /**
     * 获取code
     *
     * @param parentCode
     * @param parentId
     * @return
     */
    private String getCode(String parentCode, String parentId) throws SearchException {
        DataDictionaryDTO dictionaryDTO = dictionaryDao.getLastByParentId(parentId);
        String code = dictionaryDTO != null ? dictionaryDTO.getDictionaryCode() : "0000";
        return super.getNewCode(code, parentCode);
    }
}
