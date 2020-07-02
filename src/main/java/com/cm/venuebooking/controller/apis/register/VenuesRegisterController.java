package com.cm.venuebooking.controller.apis.register;

import com.cm.common.constants.ISystemConstant;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.register.RegisterInfoDTO;
import com.cm.venuebooking.service.register.IRegisterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 场馆入驻
 * @author xwangs
 * @create 2020-06-26 17:15
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "场馆入驻接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/register")
public class VenuesRegisterController extends BaseController {

    @Autowired
    private IRegisterService registerService;

    @ApiOperation(value = "入驻信息分页列表", notes = "入驻信息分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "查询条件", paramType = "form", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagevenuesregister")
    public SuccessResultList listPageVenuesRegister(ListPage page) {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return registerService.listPageVenuesRegister(page);
    }

    @ApiOperation(value = "删除场馆入驻信息", notes = "删除场馆入驻信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "registerId", value = "入驻信息ID", paramType = "path"),
    })
    @DeleteMapping("removeregister/{id}")
    public SuccessResult removeRegister(@PathVariable("id") String id){
        return registerService.removeRegister(id);
    }

    @ApiOperation(value = "场馆入驻详情", notes = "场馆入驻详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "registerId", value = "入驻信息ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getregisterinfo/{id}")
    public RegisterInfoDTO getRegisterInfo(@PathVariable("id") String id) {
        return registerService.getRegisterInfo(id);
    }

    @ApiOperation(value = "获取未绑定的用户列表", notes = "获取未绑定的用户列表")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getunbindregisteruser")
    public SuccessResultData getUnbindRegisterUser() {
        return registerService.getUnbindRegisterUser();
    }

    @ApiOperation(value = "审核入驻申请", notes = "获取未绑定的用户列表")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("updateregisterinfo")
    public SuccessResult updateRegisterInfo(@RequestBody RegisterInfoDTO registerInfoDTO) throws Exception{
        return registerService.updateRegisterInfo(registerInfoDTO);
    }
}
