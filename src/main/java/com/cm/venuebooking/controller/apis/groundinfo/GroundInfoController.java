package com.cm.venuebooking.controller.apis.groundinfo;

import com.alibaba.fastjson.JSONObject;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.common.utils.HashMapUtil;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.vos.groundinfo.GroundInfoVO;
import com.cm.venuebooking.service.groundinfo.IGroundInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 场地场次controller
 * @author xwangs
 * @create 2020-06-01 20:47
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "场地场次接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/groundinfo")
public class GroundInfoController extends BaseController {

    @Autowired
    private IGroundInfoService groundInfoService;

    @ApiOperation(value = "场地列表", notes = "场地列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagevenuesinfo")
    public SuccessResultList listPageGroundInfo(ListPage page){
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return groundInfoService.listPageGroundInfo(page);
    }

    @ApiOperation(value = "场地场次保存", notes = "场地场次保存接口(JSONObject)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("savegroundinfo")
    public SuccessResult saveGroundInfo(@RequestBody JSONObject jsonObject) {
        return groundInfoService.saveGroundInfo(jsonObject);
    }

    @ApiOperation(value = "单查场地场次", notes = "单查场地场次接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getgroundinfo/{groundInfoId}")
    public SuccessResult getGroundInfo(@PathVariable("groundInfoId") String groundInfoId){
        return groundInfoService.getGroundInfo(groundInfoId);
    }

    @ApiOperation(value = "修改场地及场次", notes = "修改场地及场次接口(JSONObject)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("updategroundinfo")
    public SuccessResult updateGroundInfo(@RequestBody JSONObject jsonObject){
        return groundInfoService.updateGroundInfo(jsonObject);
    }

    @ApiOperation(value = "修改场地开关状态", notes = "修改场地开关状态")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("updateopenclosetype/{groundInfoId}/{openCloseType}")
    public SuccessResult updateOpenCloseType(@PathVariable("groundInfoId") String groundInfoId,
                                             @PathVariable("openCloseType") String openCloseType) throws Exception{
        Map<String, Object> param = getParams();
        param.put("groundInfoId", groundInfoId);
        param.put("openCloseType", openCloseType);
        return groundInfoService.updateOpenCloseType(param);
    }

    @ApiOperation(value = "删除场地", notes="删除场地接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @DeleteMapping("removegroundinfo/{groundInfoId}")
    public SuccessResult removeGroundInfo(@PathVariable("groundInfoId") String ids){
        groundInfoService.removeGroundInfo(ids);
        return new SuccessResult();
    }
}
