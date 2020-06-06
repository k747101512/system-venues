package com.cm.venuebooking.controller.apis.venuesproject;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.base.AbstractController;
import com.cm.common.component.SecurityComponent;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.RemoveException;
import com.cm.common.exception.SearchException;
import com.cm.common.plugin.service.datadictionary.IDataDictionaryService;
import com.cm.common.pojo.ListPage;
import com.cm.common.pojo.dtos.CurrentUserIdInfoDTO;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectDTO;
import com.cm.venuebooking.pojo.dtos.venuesproject.VenuesProjectForListDTO;
import com.cm.venuebooking.pojo.vos.venuesproject.VenuesProjectVO;
import com.cm.venuebooking.service.venuesproject.IVenuesProjectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: VenuesProjectController
 * @Description: 场馆项目表
 * @Author: WenG
 * @Date: 2020-04-26 12:07
 * @Version: 1.0
 **/
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "场馆项目表接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/venuesproject")
public class VenuesProjectController extends AbstractController {

    @Autowired
    private IVenuesProjectService venuesProjectService;
    @Autowired
    private SecurityComponent securityComponent;

    @ApiOperation(value = "新增场馆项目表", notes = "新增场馆项目表接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("savevenuesproject")
    @CheckRequestBodyAnnotation
    public SuccessResult saveVenuesProject(@RequestBody VenuesProjectVO venuesProjectVO) throws Exception {
        return venuesProjectService.saveVenuesProject(venuesProjectVO);
    }

    @ApiOperation(value = "删除场馆项目表(id列表)", notes = "删除场馆项目表(id列表)接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ID列表，用下划线分隔", paramType = "path", example = "1_2_3")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("removevenuesproject/{ids}")
    public SuccessResult removeVenuesProject(@PathVariable("ids") String ids) throws RemoveException {
        return venuesProjectService.removeVenuesProject(ids);
    }

    @ApiOperation(value = "修改场馆项目表", notes = "修改场馆项目表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venuesProjectId", value = "场馆项目表ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("updatevenuesproject/{venuesProjectId}")
    @CheckRequestBodyAnnotation
    public SuccessResult updateVenuesProject(@PathVariable("venuesProjectId") String venuesProjectId, @RequestBody VenuesProjectVO venuesProjectVO) throws Exception {
        return venuesProjectService.updateVenuesProject(venuesProjectId, venuesProjectVO);
    }

    @ApiOperation(value = "场馆项目表详情(通过ID)", notes = "场馆项目表详情(通过ID)接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venuesProjectId", value = "场馆项目表ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getvenuesprojectbyid/{venuesProjectId}")
    public VenuesProjectDTO getVenuesProjectById(@PathVariable("venuesProjectId") String venuesProjectId) throws SearchException {
        return venuesProjectService.getVenuesProjectById(venuesProjectId);
    }

    @ApiOperation(value = "场馆项目表列表", notes = "场馆项目表列表接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listvenuesproject")
    public List<VenuesProjectDTO> listVenuesProject() throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesProjectService.listVenuesProject(params);
    }

    @ApiOperation(value = "场馆项目表分页列表", notes = "场馆项目表分页列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "form", dataType = "String"),
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagevenuesproject")
    public SuccessResultList<List<VenuesProjectDTO>> listPageVenuesProject(ListPage page) throws SearchException {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return venuesProjectService.listPageVenuesProject(page);
    }

    @ApiOperation(value = "当前用户id信息", notes = "当前用户id信息接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getcurrentuseridinfo")
    public CurrentUserIdInfoDTO getCurrentUserIdInfo() {
        return securityComponent.getCurrentUserIdInfo();
    }

    @ApiOperation(value = "场馆项目分页列表-关联", notes = "场馆项目分页列表-关联接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "查询条件", paramType = "form", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagevenuesprojectlocal")
    public SuccessResultList<List<VenuesProjectForListDTO>> listPageVenuesProjectLocal(ListPage page) throws SearchException {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return venuesProjectService.listPageVenuesProjectLocal(page);
    }

}