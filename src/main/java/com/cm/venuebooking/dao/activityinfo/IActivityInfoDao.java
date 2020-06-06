package com.cm.venuebooking.dao.activityinfo;

import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoDTO;
import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 12:25
 * @description
 */
@Repository
public interface IActivityInfoDao {

    void saveActivityInfo(Map<String, Object> params);

    List<ActivityInfoListDTO> listActivityListInfo(Map<String, Object> param);

    ActivityInfoDTO getActivityInfoDetail(Map<String, Object> param);

    List<ActivityInfoDTO> listPageActivityInfo(Map<String, Object> params);
}
