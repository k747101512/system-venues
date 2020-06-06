package com.cm.venuebooking.controller.apis.venuearticle;

import com.cm.common.annotation.CheckRequestBodyAnnotation;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResult;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
import com.cm.venuebooking.pojo.dtos.venuedictionary.VenueDictionaryDTO;
import com.cm.venuebooking.pojo.vos.venuearticle.VenueArticleVO;
import com.cm.venuebooking.pojo.vos.venuedictionary.VenueDictionaryVO;
import com.cm.venuebooking.service.venuearticle.IVenueArticleService;
import com.cm.venuebooking.service.venuedictionary.IVenueDictionaryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xwangs
 * @create 2020-05-27 14:17
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_SYSTEM_PREFIX + "新闻接口")
@RestController
@RequestMapping(ISystemConstant.API_PREFIX + "/venuearticle")
public class VenueArticleController extends BaseController {

    @Autowired
    private IVenueArticleService venueArticleService;

    @ApiOperation(value = "新增", notes = "新增接口")
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PostMapping("save")
    @CheckRequestBodyAnnotation
    public SuccessResult saveDictionary(@RequestBody VenueArticleVO venueArticleVO) throws Exception {
        return venueArticleService.save(venueArticleVO);
    }

    @ApiOperation(value = "详情（ID查询）", notes = "详情（ID查询）接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleContentId", value = "articleContentId", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getvenuearticlerbyid/{articleContentId}")
    public VenueArticleDTO getVenueDictionaryById(@PathVariable("articleContentId") String articleContentId) throws SearchException {
        return venueArticleService.getVenueArticleById(articleContentId);
    }

    @ApiOperation(value = "修改", notes = "修改接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleContentId", value = "articleContentId", paramType = "path")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @PutMapping("update/{articleContentId}")
    @CheckRequestBodyAnnotation
    public SuccessResult update(@PathVariable("articleContentId") String articleContentId,
                                @RequestBody VenueArticleDTO venueArticleDTO) throws Exception {
        return venueArticleService.update(articleContentId, venueArticleDTO);
    }

}
