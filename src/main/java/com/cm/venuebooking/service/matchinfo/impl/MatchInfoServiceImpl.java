package com.cm.venuebooking.service.matchinfo.impl;

import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.matchinfo.IMatchInfoDao;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoListDTO;
import com.cm.venuebooking.pojo.vos.matchinfo.MatchInfoVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.matchinfo.IMatchInfoService;
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
class MatchInfoServiceImpl extends BaseService implements IMatchInfoService {

    @Autowired
    private IMatchInfoDao matchInfoDao;

    @Override
    public SuccessResult saveMatchInfo(MatchInfoVO matchInfoVO) throws Exception {
        Map<String, Object> params = HashMapUtil.beanToMap(matchInfoVO);
        String matchId = UUIDUtil.getUUID();
        params.put("matchId",matchId);
        setSaveInfo(params);
        matchInfoDao.saveMatchInfo(params);
        return new SuccessResult();
    }

    @Override
    public SuccessResultList<List<MatchInfoDTO>> listPageMatchInfo(ListPage page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<MatchInfoDTO> list = matchInfoDao.listPageMatchInfo(page.getParams());
        PageInfo<MatchInfoDTO> pageInfo = new PageInfo<>(list);
        return new SuccessResultList<>(list,pageInfo.getPageNum(),pageInfo.getTotal());
    }

    @Override
    public List<MatchInfoListDTO> listMatchListInfo(Map<String, Object> param) throws SearchException {
        List<MatchInfoListDTO> list = matchInfoDao.listMatchListInfo(param);
        for(MatchInfoListDTO item : list ){
            item.setFrontCover(item.getFrontCover().split(",")[0]);
        }
        return list;
    }

    @Override
    public MatchInfoDTO getMatchInfoDetail(Map<String, Object> param) {
        String matchId = StringUtils.isEmpty(param.get("matchId")) ?
                "" : param.get("matchId").toString();
        if("".equals(matchId)){
            return new MatchInfoDTO();
        }
        return matchInfoDao.getMatchInfoDetail(param);
    }

}
