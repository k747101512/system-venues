package com.cm.venuebooking.service.venuearticle.impl;

import com.cm.common.article.pojo.dtos.articlecontent.ArticleContentDTO;
import com.cm.common.exception.SearchException;
import com.cm.common.result.SuccessResult;
import com.cm.common.utils.HashMapUtil;
import com.cm.common.utils.UUIDUtil;
import com.cm.venuebooking.dao.venuearticle.IVenueArticleDao;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
import com.cm.venuebooking.pojo.vos.venuearticle.VenueArticleVO;
import com.cm.venuebooking.service.BaseService;
import com.cm.venuebooking.service.venuearticle.IVenueArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-29 11:50
 * @description
 */
@Service
public class VenueArticleServiceImpl extends BaseService implements IVenueArticleService {

    @Autowired
    private IVenueArticleDao venueArticleDao;

    @Override
    public SuccessResult save(VenueArticleVO venueArticleVO) throws Exception{
        Map<String, Object> param = HashMapUtil.beanToMap(venueArticleVO);
        String articleContentId = UUIDUtil.getUUID();
        param.put("articleContentId",articleContentId);
        setSaveInfo(param);
        venueArticleDao.save(param);
        return new SuccessResult();
    }

    @Override
    public VenueArticleDTO getVenueArticleById(String id) throws SearchException {
        Map<String, Object> param = getHashMap(1);
        param.put("articleContentId",id);
        return venueArticleDao.getVenueArticle(param);
    }

    @Override
    public SuccessResult update(String articleContentId, VenueArticleDTO venueArticleDTO) throws Exception {
        Map<String, Object> param = HashMapUtil.beanToMap(venueArticleDTO);
        setUpdateInfo(param);
        param.put("articleContentId",articleContentId);
        venueArticleDao.update(param);
        return new SuccessResult();
    }

    @Override
    public List<VenueArticleDTO> listVenueArticle(Map<String, Object> param) {
        //articleCategoryId
        return venueArticleDao.listVenueArticle(param);
    }
}
