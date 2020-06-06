package com.cm.venuebooking.controller.wechat.apis;

import com.cm.common.article.pojo.dtos.articlecontent.ArticleContentDTO;
import com.cm.common.article.service.articlecontent.IArticleContentService;
import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResultData;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoDTO;
import com.cm.venuebooking.pojo.dtos.matchinfo.MatchInfoListDTO;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
import com.cm.venuebooking.service.activityinfo.IActivityInfoService;
import com.cm.venuebooking.service.matchinfo.IMatchInfoService;
import com.cm.venuebooking.service.venuearticle.IVenueArticleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xwangs
 * @create 2020-05-14 10:53
 * @description
 */
@Api(tags = ISystemConstant.API_TAGS_WECHAT_MINI_APP_PREFIX + "新闻类文章发布")
@RestController
@RequestMapping(ISystemConstant.WECHAT_MINI_APP_PREFIX + "/article")
public class WeChatMiniAppArticleController extends BaseController {

    @Autowired
    private IVenueArticleService articleService;

    @Autowired
    private IMatchInfoService matchInfoService;

    @Autowired
    private IActivityInfoService activityInfoService;

    @ApiOperation(value = "普通新闻详情", notes = "普通新闻详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
            @ApiImplicitParam(name = "articleContentId", value = "articleContentId", paramType = "query")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getarticledetail" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData getArticleDetail() throws SearchException {
        Map<String,Object> param = requestParams();
        String articleContentId = StringUtils.isEmpty(param.get("articleContentId"))?
                "" : param.get("articleContentId").toString();
        if("".equals(articleContentId)){
            throw  new SearchException("主键缺失查询失败");
        }
        VenueArticleDTO venueArticleDTO = articleService.getVenueArticleById(articleContentId);
        return new SuccessResultData(venueArticleDTO);
    }

    @ApiOperation(value = "普通新闻列表", notes = "普通新闻详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleCategoryId", value = "articleCategoryId", paramType = "query")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listarticlebycategory" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData listArticleByCategory() throws  SearchException {
        Map<String,Object> param = requestParams();
        String articleCategoryId = StringUtils.isEmpty(param.get("articleCategoryId"))?
                "" : param.get("articleCategoryId").toString();
        if("".equals(articleCategoryId)){
            throw  new SearchException("分类ID缺失查询失败");
        }
        List<VenueArticleDTO> list = articleService.listVenueArticle(param);
        return new SuccessResultData(list);
    }

    @ApiOperation(value = "赛事列表", notes = "赛事列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listmatchlistinfo" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData listMatchInfo() throws  SearchException {
        Map<String,Object> param = requestParams();
        List<MatchInfoListDTO> list = matchInfoService.listMatchListInfo(param);
        return new SuccessResultData(list);
    }

    @ApiOperation(value = "赛事详情", notes = "赛事详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
            @ApiImplicitParam(name = "matchId", value = "matchId", paramType = "query"),
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getmatchinfodetail" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData getMatchInfoDetail() throws  SearchException {
        Map<String,Object> param = requestParams();
        MatchInfoDTO matchInfoDTO = matchInfoService.getMatchInfoDetail(param);
        return new SuccessResultData(matchInfoDTO);
    }

    @ApiOperation(value = "活动列表", notes = "赛事列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listactivitylistinfo" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData listActivityListInfo() throws  SearchException {
        Map<String,Object> param = requestParams();
        return activityInfoService.listActivityListInfo(param);
    }

    @ApiOperation(value = "活动详情", notes = "活动详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", paramType = "header"),
            @ApiImplicitParam(name = "activityId", value = "activityId", paramType = "query"),
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("getactivityinfodetail" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultData getActivityInfoDetail() throws  SearchException {
        Map<String,Object> param = requestParams();
        return activityInfoService.getActivityInfoDetail(param);
    }

}
