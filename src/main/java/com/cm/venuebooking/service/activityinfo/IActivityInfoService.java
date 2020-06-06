package com.cm.venuebooking.service.activityinfo;

import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoDTO;
import com.cm.venuebooking.pojo.vos.activityinfo.ActivityInfoVO;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 12:22
 * @description
 */
public interface IActivityInfoService {

    SuccessResult saveActivityInfo(ActivityInfoVO activityInfoVO) throws Exception;

    SuccessResultData listActivityListInfo(Map<String, Object> param) throws SearchException;

    SuccessResultData getActivityInfoDetail(Map<String, Object> param) throws SearchException;

    SuccessResultList<List<ActivityInfoDTO>> listPageActivityInfo(ListPage page) throws SearchException;
}
