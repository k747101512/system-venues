package com.cm.venuebooking.service.venuearticle;

import com.cm.common.article.pojo.dtos.articlecontent.ArticleContentDTO;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.pojo.dtos.ZTreeDTO;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
import com.cm.venuebooking.pojo.vos.venuearticle.VenueArticleVO;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-29 11:50
 * @description
 */
public interface IVenueArticleService {

    /**
     * 保存
     * @param venueArticleVO
     * @return
     * @throws Exception
     */
    SuccessResult save(VenueArticleVO venueArticleVO) throws Exception;

    /**
     * 查询一条
     * @param id
     * @return
     * @throws SearchException
     */
    VenueArticleDTO getVenueArticleById(String id) throws SearchException;


    /**
     * 修改
     * @param articleContentId
     * @param venueArticleDTO
     * @return
     */
    SuccessResult update(String articleContentId, VenueArticleDTO venueArticleDTO) throws Exception;


    /**
     * 根据分类查询新闻类表
     * @param page
     * @return
     */
    SuccessResultList<List<VenueArticleDTO>> listPageArticleByCategory(ListPage page);

    /**
     * 文章类型zTree列表
     * @return
     */
    List<ZTreeDTO> listVenueArticleZTree();
}
