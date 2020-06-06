package com.cm.venuebooking.controller.apis.venuedictionary;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.venuedictionary.VenueDictionaryDTO;
import com.cm.venuebooking.pojo.vos.venuedictionary.VenueDictionaryVO;
import com.cm.venuebooking.service.venuedictionary.IVenueDictionaryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xwangs
 * @create 2020-05-27 14:17
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "场馆基础数据维护接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/venuedictionary")
public class VenueDictionaryController extends BaseController {

    @Autowired
    private IVenueDictionaryService venueDictionaryService;

    @ApiOperation(value = "新增", notes = "新增接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("save")
    @CheckRequestBodyAnnotation
    public SuccessResult saveDictionary(@RequestBody VenueDictionaryVO venueDictionaryVO) throws Exception {
        return venueDictionaryService.save(venueDictionaryVO);
    }

    @ApiOperation(value = "详情（ID查询）", notes = "详情（ID查询）接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionaryId", value = "ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getvenuedictionarybyid/{dictionaryId}")
    public VenueDictionaryDTO getVenueDictionaryById(@PathVariable("dictionaryId") String dictionaryId) throws Exception {
        return venueDictionaryService.getVenueDictionaryById(dictionaryId);
    }

    @ApiOperation(value = "修改", notes = "修改接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictionaryId", value = "字典ID", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("update/{dictionaryId}")
    @CheckRequestBodyAnnotation
    public SuccessResult update(@PathVariable("dictionaryId") String dictionaryId, @RequestBody VenueDictionaryDTO venueDictionaryDTO) throws Exception {
        return venueDictionaryService.update(dictionaryId, venueDictionaryDTO);
    }

}
