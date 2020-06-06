package com.cm.venuebooking.service.activityinfo.impl;

import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.activityinfo.IActivityInfoDao;
import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoDTO;
import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoListDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.vos.activityinfo.ActivityInfoVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.activityinfo.IActivityInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 12:23
 * @description
 */
@Service
public
class ActivityInfoServiceImpl extends BaseService implements IActivityInfoService {

    @Autowired
    private IActivityInfoDao activityInfoDao;

    @Override
    public SuccessResult saveActivityInfo(ActivityInfoVO activityInfoVO) throws Exception{
        Map<String, Object> params = HashMapUtil.beanToMap(activityInfoVO);
        String activityId = UUIDUtil.getUUID();
        params.put("activityId",activityId);
        setSaveInfo(params);
        activityInfoDao.saveActivityInfo(params);
        return new SuccessResult();
    }

    @Override
    public SuccessResultList<List<ActivityInfoDTO>> listPageActivityInfo(ListPage page) throws SearchException {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<ActivityInfoDTO> activityInfoDTOS = activityInfoDao.listPageActivityInfo(page.getParams());
        PageInfo<ActivityInfoDTO> pageInfo = new PageInfo<>(activityInfoDTOS);
        return new SuccessResultList<>(activityInfoDTOS,pageInfo.getPageNum(),pageInfo.getTotal());
    }

    @Override
    public SuccessResultData listActivityListInfo(Map<String, Object> param) throws SearchException {
        List<ActivityInfoListDTO> list = activityInfoDao.listActivityListInfo(param);
        for(ActivityInfoListDTO item : list){
            item.setFrontCover(item.getFrontCover().split(",")[0]);
        }
        return new SuccessResultData(list);
    }

    @Override
    public SuccessResultData getActivityInfoDetail(Map<String, Object> param) throws SearchException {
        String activityId = StringUtils.isEmpty(param.get("activityId")) ?
                "" : param.get("activityId").toString();
        if("".equals(activityId)){
            throw new SearchException("参数缺失查询失败");
        }
        ActivityInfoDTO activityInfoDTO = activityInfoDao.getActivityInfoDetail(param);
        return new SuccessResultData(activityInfoDTO);
    }
}
