package com.cm.venuebooking.controller.apis.groundbooking;

import com.cm.common.constants.ISystemConstant;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.service.groundbooking.IGroundBookingService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 场馆订单
 * @author xwangs
 * @create 2020-06-04 21:46
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "场馆订单")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/groundbooking")
public class GroundBookingController extends BaseController {

    @Autowired
    private IGroundBookingService groundBookingService;

    @ApiOperation(value = "订单分页列表", notes = "订单分页列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "keywords", value = "检索条件", paramType = "form", dataType = "String")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagebookingorder")
    public SuccessResultList listPageBookingOrder(ListPage page){
        Map<String, Object> param = requestParams();
        page.setParams(param);
        return groundBookingService.listPageBookingOrder(page);
    }

}
