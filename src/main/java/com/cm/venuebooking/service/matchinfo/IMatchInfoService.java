package com.cm.venuebooking.service.matchinfo;

import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoListDTO;
import com.cm.venuebooking.pojo.vos.matchinfo.MatchInfoVO;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 12:22
 * @description
 */
public interface IMatchInfoService {

    /**
     * 保存赛事
     * @param matchInfoVO
     * @return
     * @throws Exception
     */
    SuccessResult saveMatchInfo(MatchInfoVO matchInfoVO) throws Exception;

    List<MatchInfoListDTO> listMatchListInfo(Map<String, Object> param);

    MatchInfoDTO getMatchInfoDetail(Map<String, Object> param);

    SuccessResultList<List<MatchInfoDTO>> listPageMatchInfo(ListPage page);
}
