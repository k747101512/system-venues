package com.cm.venuebooking.controller.apis.matchinfocontroller;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.vos.matchinfo.MatchInfoVO;
import com.cm.venuebooking.service.matchinfo.IMatchInfoService;
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
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "赛事接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/matchinfo")
public class MatchInfoController extends BaseController {

    @Autowired
    private IMatchInfoService matchInfoService;

    @ApiOperation(value = "新增赛事信息", notes = "新增赛事信息接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("savematchinfo")
    @CheckRequestBodyAnnotation
    public SuccessResult saveMatchInfo(@RequestBody MatchInfoVO matchInfoVO) throws Exception {
        return matchInfoService.saveMatchInfo(matchInfoVO);
    }

    @ApiOperation(value = "赛事信息分页列表", notes = "赛事信息分页列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "关键字", paramType = "form", dataType = "String"),
    })
    @GetMapping("listpagematchinfo")
    public SuccessResultList<List<MatchInfoDTO>> listPageMatchInfo(ListPage page) throws SearchException {
        Map<String, Object> param = requestParams();
        page.setParams(param);
        return matchInfoService.listPageMatchInfo(page);
    }
}
