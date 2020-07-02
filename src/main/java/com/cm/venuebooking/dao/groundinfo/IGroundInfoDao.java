package com.cm.venuebooking.dao.groundinfo;

import com.cm.common.exception.SaveException;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundInfoDTO;
import com.cm.venuebooking.pojo.dtos.groundinfo.GroundItemDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 场地场次Dao
 * @author xwangs
 * @create 2020-06-01 20:57
 * @description
 */
@Repository
public interface IGroundInfoDao {

    /**
     * 保存场地
     * @param param
     */
    void saveGroundInfo(Map<String, Object> param);

    /**
     * 保存场次
     * @param param
     */
    void saveGroundItem(Map<String, Object> param);


    /**
     * 单查场地信息
     * @param param
     * @return
     */
    GroundInfoDTO getGroundInfo(Map<String, Object> param);


    /**
     * 场次列表
     * @param param
     * @return
     */
    List<GroundItemDTO> listGroundItem(Map<String, Object> param);

    /**
     * 更新场地信息
     * @param param
     */
    void updateGroundInfo(Map<String, Object> param);

    /**
     * 更新场次信息
     * @param param
     */
    void updateGroundItem(Map<String, Object> param);

    /**
     * 场地列表分页
     * @param params
     * @return
     */
    List<GroundInfoDTO> listPageGroundInfo(Map<String, Object> params);

    /**
     * 删除场地
     * @param params
     */
    void removeGroundInfo(Map<String, Object> params);

    /**
     * 场地列表
     * @param param
     */
    List<GroundInfoDTO> listGroundInfo(Map<String, Object> param);

    /**
     * 查询场次时刻(单条)
     * @param param
     * @return
     */
    GroundItemDTO getGroundItem(Map<String, Object> param);
}
