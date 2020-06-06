package com.cm.venuebooking.pojo.vos.venuedictionary;

import com.cm.common.annotation.CheckEmptyAnnotation;
import com.cm.common.annotation.CheckNumberAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: DictionaryVO
 * @Description: 字典视图
 * @Author: WangGeng
 * @Date: 2019/3/4 2:30 PM
 * @Version: 1.0
 **/
@ApiModel
public class VenueDictionaryVO {

    @ApiModelProperty(name = "dictionaryParentId", value = "上级ID")
    @CheckEmptyAnnotation(name = "上级ID")
    private String dictionaryParentId;
    @ApiModelProperty(name = "dictionaryName", value = "名称")
    @CheckEmptyAnnotation(name = "名称")
    private String dictionaryName;
    @ApiModelProperty(name = "dictionarySummary", value = "说明")
    private String dictionarySummary;
    @ApiModelProperty(name = "dictionaryIcon", value = "说明")
    private String dictionaryIcon;
    @ApiModelProperty(name = "dictionarySort", value = "排序")
    @CheckNumberAnnotation(name = "排序")
    private Integer dictionarySort;

    public String getDictionaryParentId() {
        return dictionaryParentId == null ? "" : dictionaryParentId;
    }

    public void setDictionaryParentId(String dictionaryParentId) {
        this.dictionaryParentId = dictionaryParentId;
    }

    public String getDictionaryName() {
        return dictionaryName == null ? "" : dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getDictionaryIcon() {
        return dictionaryIcon == null ? "" : dictionaryIcon;
    }

    public void setDictionaryIcon(String dictionaryIcon) {
        this.dictionaryIcon = dictionaryIcon;
    }

    public String getDictionarySummary() {
        return dictionarySummary == null ? "" : dictionarySummary;
    }

    public void setDictionarySummary(String dictionarySummary) {
        this.dictionarySummary = dictionarySummary;
    }

    public Integer getDictionarySort() {
        return dictionarySort;
    }

    public void setDictionarySort(Integer dictionarySort) {
        this.dictionarySort = dictionarySort;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"dictionaryParentId\":\"")
                .append(dictionaryParentId).append('\"');
        sb.append(",\"dictionaryName\":\"")
                .append(dictionaryName).append('\"');
        sb.append(",\"dictionarySummary\":\"")
                .append(dictionarySummary).append('\"');
        sb.append(",\"dictionaryIcon\":\"")
                .append(dictionaryIcon).append('\"');
        sb.append(",\"dictionarySort\":")
                .append(dictionarySort);
        sb.append('}');
        return sb.toString();
    }
}
