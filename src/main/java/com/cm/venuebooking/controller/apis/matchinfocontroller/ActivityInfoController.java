package com.cm.venuebooking.controller.apis.matchinfocontroller;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.activityinfo.ActivityInfoDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.vos.activityinfo.ActivityInfoVO;
import com.cm.venuebooking.service.activityinfo.IActivityInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-15 10:53
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "活动接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/activityinfo")
public class ActivityInfoController extends BaseController {

    @Autowired
    private IActivityInfoService activityInfoService;

    @ApiOperation(value = "新增活动信息", notes = "新增赛活动息接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("saveactivityinfo")
    @CheckRequestBodyAnnotation
    public SuccessResult saveActivityInfo(@RequestBody ActivityInfoVO activityInfoVO) throws Exception {
        return activityInfoService.saveActivityInfo(activityInfoVO);
    }

    @ApiOperation(value = "活动信息分页列表", notes = "活动信息分页列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "form", dataType = "String"),
    })
    @GetMapping("listpageactivityinfo")
    public SuccessResultList<List<ActivityInfoDTO>> listPageActivityInfo(ListPage page) throws SearchException {
        Map<String, Object> param = requestParams();
        page.setParams(param);
        return activityInfoService.listPageActivityInfo(page);
    }
}
