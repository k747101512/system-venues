package com.cm.venuebooking.dao.venuedictionary;

import com.cm.venuebooking.pojo.dtos.venuedictionary.VenueDictionaryDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-27 14:28
 * @description
 */
@Repository
public interface IVenueDictionaryDao {

    /**
     * 保存
     * @param params
     */
    void save(Map<String, Object> params);

    /**
     * 查询单条数据
     * @param params
     * @return
     */
    VenueDictionaryDTO getVenueDictionary(Map<String, Object> params);

    /**
     * 修改
     * @param params
     */
    void update(Map<String, Object> params);
}
