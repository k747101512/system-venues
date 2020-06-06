package com.cm.venuebooking.pojo.dtos.venuedictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * When you feel like quitting. Think about why you started
 * 当你想要放弃的时候，想想当初你为何开始
 *
 * @ClassName: VenueDictionaryDTO
 * @Description: 场馆字典
 * @Version: 1.0
 **/
@ApiModel
public class VenueDictionaryDTO {

    @ApiModelProperty(name = "dictionaryId", value = "ID")
    private String dictionaryId;
    @ApiModelProperty(name = "dictionaryParentId", value = "上级ID")
    private String dictionaryParentId;
    @ApiModelProperty(name = "dictionaryParentName", value = "上级名称")
    private String dictionaryParentName;
    @ApiModelProperty(name = "isParent", value = "是否父级")
    private Boolean isParent;
    @ApiModelProperty(name = "dictionaryName", value = "名称")
    private String dictionaryName;
    @ApiModelProperty(name = "dictionaryIcon", value = "图标")
    private String dictionaryIcon;
    @ApiModelProperty(name = "dictionarySummary", value = "说明")
    private String dictionarySummary;
    @ApiModelProperty(name = "dictionaryCode", value = "编码")
    private String dictionaryCode;
    @ApiModelProperty(name = "dictionarySort", value = "排序")
    private String dictionarySort;
    @ApiModelProperty(name = "subDictionary", value = "子列表")
    private List<VenueDictionaryDTO> subDictionary;

    public String getDictionaryId() {
        return dictionaryId == null ? "" : dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDictionaryParentId() {
        return dictionaryParentId == null ? "" : dictionaryParentId;
    }

    public void setDictionaryParentId(String dictionaryParentId) {
        this.dictionaryParentId = dictionaryParentId;
    }

    public String getDictionaryParentName() {
        return dictionaryParentName == null ? "" : dictionaryParentName;
    }

    public void setDictionaryParentName(String dictionaryParentName) {
        this.dictionaryParentName = dictionaryParentName;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
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

    public String getDictionaryCode() {
        return dictionaryCode == null ? "" : dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionarySort() {
        return dictionarySort == null ? "" : dictionarySort.trim();
    }

    public void setDictionarySort(String dictionarySort) {
        this.dictionarySort = dictionarySort;
    }

    public List<VenueDictionaryDTO> getSubDictionary() {
        if (subDictionary == null) {
            return new ArrayList<>();
        }
        return subDictionary;
    }

    public void setSubDictionary(List<VenueDictionaryDTO> subDictionary) {
        this.subDictionary = subDictionary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"dictionaryId\":\"")
                .append(dictionaryId).append('\"');
        sb.append(",\"dictionaryParentId\":\"")
                .append(dictionaryParentId).append('\"');
        sb.append(",\"dictionaryParentName\":\"")
                .append(dictionaryParentName).append('\"');
        sb.append(",\"isParent\":")
                .append(isParent);
        sb.append(",\"dictionaryName\":\"")
                .append(dictionaryName).append('\"');
        sb.append(",\"dictionaryIcon\":\"")
                .append(dictionaryIcon).append('\"');
        sb.append(",\"dictionarySummary\":\"")
                .append(dictionarySummary).append('\"');
        sb.append(",\"dictionaryCode\":\"")
                .append(dictionaryCode).append('\"');
        sb.append(",\"dictionarySort\":\"")
                .append(dictionarySort).append('\"');
        sb.append(",\"subDictionary\":")
                .append(subDictionary);
        sb.append('}');
        return sb.toString();
    }
}
