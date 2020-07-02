package com.cm.venuebooking.controller.wechat.apis;

import com.cm.common.constants.ISystemConstant;
import com.cm.common.exception.SearchException;
import com.cm.common.pojo.ListPage;
import com.cm.common.result.ErrorResult;
import com.cm.common.result.SuccessResultData;
import com.cm.common.result.SuccessResultList;
import com.cm.venuebooking.controller.BaseController;
import com.cm.venuebooking.pojo.dtos.venuearticle.VenueArticleDTO;
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
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "form", dataType = "Integer", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "显示数量", paramType = "form", dataType = "Integer", defaultValue = "20"),
            @ApiImplicitParam(name = "articleCategoryId", value = "articleCategoryId", paramType = "query")
    })
    @ApiResponses({@ApiResponse(code = 400, message = "请求失败", response = ErrorResult.class)})
    @GetMapping("listpagearticlebycategory" + ISystemConstant.APP_RELEASE_SUFFIX)
    public SuccessResultList<List<VenueArticleDTO>> listPageArticleByCategory(ListPage page) throws  SearchException {
        Map<String,Object> param = requestParams();
        page.setParams(param);
        return articleService.listPageArticleByCategory(page);
    }

}
