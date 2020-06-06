package com.cm.venuebooking.dao.venuearticle;

import com.cm.common.exception.SearchException;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-29 11:52
 * @description
 */
@Repository
public interface IVenueArticleDao {

    /**
     * 保存新闻
     * @param param
     * @throws Exception
     */
    void save(Map<String, Object> param) throws Exception;

    /**
     * 查询一条
     * @param param
     * @return
     * @throws SearchException
     */
    VenueArticleDTO getVenueArticle(Map<String, Object> param) throws SearchException;

    /**
     * 修改
     * @param param
     * @throws Exception
     */
    void update(Map<String, Object> param) throws Exception;


    /**
     * 根据类型查询新闻列表
     * @param param articleCategoryId 类型ID
     * @return
     */
    List<VenueArticleDTO> listVenueArticle(Map<String, Object> param);
}
