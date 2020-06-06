package com.cm.venuebooking.dao.venuesproject;

import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.exception.UpdateException;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectDTO;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectForListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IVenuesProjectDao
 * @Description: 场馆项目表
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
@Repository
public interface IVenuesProjectDao {

    /**
     * 新增场馆项目表
     *
     * @param params
     * @throws SaveException
     */
    void saveVenuesProject(Map<String, Object> params) throws SaveException;

    /**
     * 删除场馆项目表
     *
     * @param params
     * @throws RemoveException
     */
    void removeVenuesProject(Map<String, Object> params) throws RemoveException;

    /**
     * 修改场馆项目表
     *
     * @param params
     * @throws UpdateException
     */
    void updateVenuesProject(Map<String, Object> params) throws UpdateException;

    /**
     * 场馆项目表详情
     *
     * @param params
     * @return
     * @throws SearchException
     */
    VenuesProjectDTO getVenuesProject(Map<String, Object> params) throws SearchException;

    /**
     * 场馆项目表列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<VenuesProjectDTO> listVenuesProject(Map<String, Object> params) throws SearchException;

    /**
     * 场馆项目分页列表-关联
     * @param params 查询条件参数
     * @return
     * @throws SearchException
     */
    List<VenuesProjectForListDTO> listVenuesProjectLocal(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-查询项目分类列表
     * @param params
     * @return
     * @throws SearchException
     */
    List<Map<String, Object>> listVenuesProjectWeChatProgram(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-查询项目详情
     * @param params
     * @return
     */
    VenuesProjectDTO getVenuesProjectDetailById(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-查询场馆所有项目
     * @param params
     * @return
     */
    List<Map<String, Object>> listVenuesProjectForWeChatProgram(Map<String, Object> params) throws SearchException;

    /**
     * 小程序-项目列表
     * @param params
     * @return
     */
    List<VenuesProjectDTO> listVenueProjectMiniApp(Map<String, Object> params);
}
