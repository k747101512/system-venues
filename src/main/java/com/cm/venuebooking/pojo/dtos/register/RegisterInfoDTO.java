package com.cm.venuebooking.pojo.dtos.register;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xwangs
 * @create 2020-05-21 16:37
 * @description
 */
@ApiModel
public class RegisterInfoDTO {

    @ApiModelProperty(name = "registerId", value = "主键")
    private String registerId;
    @ApiModelProperty(name = "orgName", value = "入驻单位名称")
    private String orgName;
    @ApiModelProperty(name = "registerName", value = "申请人")
    private String registerName;
    @ApiModelProperty(name = "cellphone", value = "联系方式")
    private String cellphone;
    @ApiModelProperty(name = "papers", value = "相关证件")
    private String papers;
    @ApiModelProperty(name = "passType", value = "审核状态")
    private String passType;
    @ApiModelProperty(name = "userName", value = "登录账号")
    private String userName;
    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;
    @ApiModelProperty(name = "defaultPassWord", value = "初始密码")
    private String defaultPassWord;
    @ApiModelProperty(name = "systemPath", value = "管理系统地址")
    private String systemPath;
    @ApiModelProperty(name = "reason", value = "管理系统地址")
    private String reason;

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

    public String getRegisterName() {
        return registerName == null ? "" : registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getCellphone() {
        return cellphone == null ? "" : cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDefaultPassWord() {
        return defaultPassWord == null ? "" : defaultPassWord;
    }

    public void setDefaultPassWord(String defaultPassWord) {
        this.defaultPassWord = defaultPassWord;
    }

    public String getSystemPath() {
        return systemPath == null ? "" : systemPath;
    }

    public void setSystemPath(String systemPath) {
        this.systemPath = systemPath;
    }

    public String getReason() {
        return reason == null ? "" : reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"registerId\":\"")
                .append(registerId).append('\"');
        sb.append(",\"orgName\":\"")
                .append(orgName).append('\"');
        sb.append(",\"registerName\":\"")
                .append(registerName).append('\"');
        sb.append(",\"cellphone\":\"")
                .append(cellphone).append('\"');
        sb.append(",\"papers\":\"")
                .append(papers).append('\"');
        sb.append(",\"passType\":\"")
                .append(passType).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"defaultPassWord\":\"")
                .append(defaultPassWord).append('\"');
        sb.append(",\"systemPath\":\"")
                .append(systemPath).append('\"');
        sb.append(",\"reason\":\"")
                .append(reason).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
