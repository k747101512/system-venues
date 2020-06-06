package com.cm.venuebooking.dao.matchinfo;

import com.cm.common.exception.SaveException;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 12:25
 * @description
 */
@Repository
public interface IMatchInfoDao {

    /**
     * 保存赛事
     * @param params
     * @throws SaveException
     */
    void saveMatchInfo(Map<String, Object> params) throws SaveException;

    List<MatchInfoListDTO> listMatchListInfo(Map<String, Object> param);

    MatchInfoDTO getMatchInfoDetail(Map<String, Object> param);

    List<MatchInfoDTO> listPageMatchInfo(Map<String, Object> params);
}
