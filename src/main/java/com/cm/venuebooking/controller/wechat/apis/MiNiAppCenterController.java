package com.cm.venuebooking.controller.wechat.apis;

import com.cm.common.constants.ISystemConstant;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.register.RegisterInfoDTO;
import com.cm.venuebooking.service.register.IRegisterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xwangs
 * @create 2020-05-25 10:55
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "提交入驻申请接口")
@RestController
@RequestMapping(ISystemConstant.WECHAT_MINI_APP_PREFIX + "/register")
public class MiNiAppCenterController extends BaseController {

    @Autowired
    private IRegisterService registerService;

    @ApiOperation(value = "保存入驻申请信息", notes = "保存入驻申请信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("saveregisterinfo")
    public SuccessResult saveRegisterInfo(@RequestHeader("token") String token, @RequestBody RegisterInfoDTO infoDTO) throws Exception {
        return registerService.saveRegisterInfo(token, infoDTO);
    }

    @ApiOperation(value = "根据token查询我的入住申请", notes = "根据token查询我的入住申请接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getregisterinfo")
    public SuccessResultData getRegisterInfo(@RequestHeader("token") String token){
        return registerService.getRegisterInfoForApp(token);
    }

    @ApiOperation(value = "更新入驻申请", notes = "更新入驻信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("updateRegisterInfo")
    public SuccessResult updateRegisterInfoForApp(@RequestHeader("token") String token, @RequestBody RegisterInfoDTO infoDTO) throws Exception {
        return registerService.updateRegisterInfoForApp(token, infoDTO);
    }

}
