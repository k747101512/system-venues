package com.cm.venuebooking.pojo.vos.register;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-21 16:37
 * @description
 */
@ApiModel
public class RegisterInfoVo {

    @ApiModelProperty(name = "registerId", value = "主键")
    private String registerId;
    @ApiModelProperty(name = "orgName", value = "入驻单位名称")
    private String orgName;
    @ApiModelProperty(name = "userName", value = "申请人")
    private String userName;
    @ApiModelProperty(name = "cellphone", value = "联系方式")
    private String cellphone;
    @ApiModelProperty(name = "location", value = "地址")
    private String location;
    @ApiModelProperty(name = "papers", value = "相关证件")
    private String papers;
    @ApiModelProperty(name = "passType", value = "审核状态")
    private String passType;

    public String getRegisterId() {
        return registerId == null ? "" : registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getOrgName() {
        return orgName == null ? "" : orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCellphone() {
        return cellphone == null ? "" : cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPapers() {
        return papers == null ? "" : papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getPassType() {
        return passType == null ? "" : passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"registerId\":\"")
                .append(registerId).append('\"');
        sb.append(",\"orgName\":\"")
                .append(orgName).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"cellphone\":\"")
                .append(cellphone).append('\"');
        sb.append(",\"location\":\"")
                .append(location).append('\"');
        sb.append(",\"papers\":\"")
                .append(papers).append('\"');
        sb.append(",\"passType\":\"")
                .append(passType).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
