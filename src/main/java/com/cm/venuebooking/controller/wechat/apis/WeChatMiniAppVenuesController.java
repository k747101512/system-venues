package com.cm.venuebooking.controller.wechat.apis;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.base.AbstractController;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.plugin.pojo.dtos.datadictionary.DataDictionaryDTO;
import com.cm.common.plugin.service.datadictionary.IDataDictionaryService;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.pojo.dtos.bookingorder.MyTicketListDTO;
import com.cm.venuebooking.pojo.vos.groundbooking.GroundTicketVO;
import com.cm.venuebooking.service.groundbooking.IGroundBookingService;
import com.cm.venuebooking.service.groundinfo.IGroundInfoService;
import com.cm.venuebooking.service.venuesinfo.IVenuesInfoService;
import com.cm.venuebooking.service.venuesproject.IVenuesProjectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信小程序场馆相关接口类
 * @author xwangs
 * @create 2020-05-07 15:47
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_APP_PREFIX + "小程序场馆接口")
@RestController
@RequestMapping(ISystemConstant.APP_PREFIX + "/wechatprogram")
public class WeChatMiniAppVenuesController extends AbstractController {

    @Autowired
    private IVenuesProjectService venuesProjectService;

    @Autowired
    private IVenuesInfoService venuesInfoService;

    @Autowired
    private IGroundInfoService groundInfoService;

    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @Autowired
    private IGroundBookingService groundBookingService;

    @ApiOperation(value = "场馆项目表列表", notes = "场馆项目表列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listvenuesproject")
    public Object listVenuesProject(@RequestHeader("token") String token) throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesProjectService.listVenuesProjectWeChatProgram(token,params);
    }

    @ApiOperation(value = "场馆列表", notes = "场馆列表列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listvenuesbykeywords")
    public SuccessResultData listvenuesByKeyWords(@RequestHeader("token") String token) throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesInfoService.listVenuesByKeyWords(token,params);
    }

    @ApiOperation(value = "小程序-场馆项目详情信息", notes = "小程序-场馆详情信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getvenuesprojectdetailbyId")
    public Object getVenuesProjectDetailById(@RequestHeader("token") String token) throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesInfoService.getVenuesProjectDetailById(token,params);
    }

    @ApiOperation(value = "小程序-根据城市名字查询字典信息", notes = "小程序-根据名字查询字典信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getcityinfobyname")
    public Object getCityInfoByName(@RequestHeader("token") String token) throws SearchException {
        Map<String, Object> param = requestParams();
        return venuesInfoService.getCityInfoByName(param);
    }

    @ApiOperation(value = "小程序-根据ID获取城市列表列表", notes = "小程序-场馆详情信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getcityareabyid/{dictionaryId}")
    public Object getCityAreaById(@RequestHeader("token") String token,
            @PathVariable("dictionaryId") String dictionaryId) throws SearchException {
        Map<String, Object> result = new HashMap<>(0);
        DataDictionaryDTO city = dataDictionaryService.getDictionaryById(dictionaryId);
        List<DataDictionaryDTO> areaList = dataDictionaryService.listDictionaryByParentId(dictionaryId);
        result.put("city",city);
        result.put("areaList",areaList);
        return result;
    }

    @ApiOperation(value = "小程序-查询场馆收费类型列表", notes = "小程序-查询场馆收费类型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listvenuechargetype")
    public Object listVenueChargeType(@RequestHeader("token") String token) throws SearchException {
        Map<String, Object> result = new HashMap<>(0);
        String dictionaryParentId = "49bc7b01-928f-487f-8b20-0658a2648918";
        List<DataDictionaryDTO> chargeType = dataDictionaryService.listDictionaryByParentId(dictionaryParentId);
        result.put("chargeType",chargeType);
        return result;
    }

    @ApiOperation(value = "场馆详情", notes = "场馆详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venuesInfoId", value = "venuesInfoId")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getvenuesdetailbyId")
    public SuccessResultData getVenuesDetailById() throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesInfoService.getVenuesDetailById(params);
    }

    @ApiOperation(value = "场馆项目列表及是否可预订", notes = "场馆项目列表及是否可预订接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venuesInfoId", value = "venuesInfoId")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listvenueproject")
    public SuccessResultData listVenueProject() throws SearchException {
        Map<String, Object> params = requestParams();
        return venuesProjectService.listVenueProjectMiniApp(params);
    }

    @ApiOperation(value = "查询场地和场次列表", notes = "查询场地和场次接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "venuesProjectId", value = "venuesProjectId")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listgroundinfoanditem")
    public SuccessResultData listGroundInfoAndItem() throws SearchException {
        Map<String, Object> params = requestParams();
        return groundInfoService.listGroundInfoMiniApp(params);
    }

    @ApiOperation(value = "保存预订订单", notes = "保存预定订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
    })
    @PostMapping("savebookinginfo")
    @CheckRequestBodyAnnotation
    public SuccessResult saveBookingInfo(@RequestHeader("token") String token,
                                         @RequestBody GroundTicketVO groundTicketVO) throws Exception {
        return groundBookingService.saveBookingInfoForApp(token,groundTicketVO);
    }

    @ApiOperation(value = "我的订单列表", notes = "我的订单列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagemyticket")
    public SuccessResultList<List<MyTicketListDTO>> listPageMyTicket(@RequestHeader("token") String token, ListPage page) throws SearchException {
        Map<String, Object> params = requestParams();
        page.setParams(params);
        return groundBookingService.listPageMyTicket(token,page);
    }

}
