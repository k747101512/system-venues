package com.cm.venuebooking.service.venuesproject;

import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SaveException;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectDTO;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectForListDTO;
import com.cm.venuebooking.pojo.vos.venuesproject.VenuesProjectVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IVenuesProjectService
 * @Description: 场馆项目表
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
public interface IVenuesProjectService {

    /**
     * 新增场馆项目表
     *
     * @param venuesProjectVO
     * @return
     * @throws Exception
     */
    SuccessResult saveVenuesProject(VenuesProjectVO venuesProjectVO) throws Exception;

    /**
     * 新增场馆项目表(APP)
     *
     * @param token
     * @param venuesProjectVO
     * @return
     * @throws Exception
     */
    SuccessResult saveVenuesProjectByToken(String token, VenuesProjectVO venuesProjectVO) throws Exception;

    /**
     * 删除场馆项目表
     *
     * @param ids
     * @return
     * @throws RemoveException
     */
    SuccessResult removeVenuesProject(String ids) throws RemoveException;

    /**
     * 删除场馆项目表(APP)
     *
     * @param token
     * @param ids
     * @return
     * @throws RemoveException
     */
    SuccessResult removeVenuesProjectByToken(String token, String ids) throws RemoveException;

    /**
     * 修改场馆项目表
     *
     * @param venuesProjectId
     * @param venuesProjectVO
     * @return
     * @throws Exception
     */
    SuccessResult updateVenuesProject(String venuesProjectId, VenuesProjectVO venuesProjectVO) throws Exception;

    /**
     * 修改场馆项目表(APP)
     *
     * @param token
     * @param venuesProjectId
     * @param venuesProjectVO
     * @return
     * @throws Exception
     */
    SuccessResult updateVenuesProjectByToken(String token, String venuesProjectId, VenuesProjectVO venuesProjectVO) throws Exception;

    /**
     * 场馆项目表详情(通过ID)
     *
     * @param venuesProjectId
     * @return
     * @throws SearchException
     */
    VenuesProjectDTO getVenuesProjectById(String venuesProjectId) throws SearchException;

    /**
     * 场馆项目表列表
     *
     * @param params
     * @return
     * @throws SearchException
     */
    List<VenuesProjectDTO> listVenuesProject(Map<String, Object> params) throws SearchException;

    /**
     * 场馆项目表分页列表
     *
     * @param page
     * @return
     * @throws SearchException
     */
    SuccessResultList<List<VenuesProjectDTO>> listPageVenuesProject(ListPage page) throws SearchException;

    /**
     * 场馆项目分页列表-关联
     * @param page 查询条件参数
     * @return
     */
    SuccessResultList<List<VenuesProjectForListDTO>> listPageVenuesProjectLocal(ListPage page) throws SearchException;

    /**
     * 场馆项目表列表
     * @param token 用户信息串
     * @param params
     * @return
     */
    Object listVenuesProjectWeChatProgram(String token, Map<String, Object> params) throws SearchException;

    /**
     * 场馆项目列表及是否可预订
     * @param params
     * @return
     */
    SuccessResultData listVenueProjectMiniApp(Map<String, Object> params);
}
