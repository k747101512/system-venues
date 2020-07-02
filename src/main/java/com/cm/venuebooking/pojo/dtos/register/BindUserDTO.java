package com.cm.venuebooking.pojo.dtos.register;

import io.swagger.annotations.ApiModelProperty;

/**
 * 入住申请用户信息
 * @author xwangs
 * @create 2020-06-29 12:06
 * @description
 */
public class BindUserDTO {

    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;
    @ApiModelProperty(name = "loginName", value = "登录账号")
    private String loginName;
    @ApiModelProperty(name = "name", value = "用户名称")
    private String name;

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName == null ? "" : loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"loginName\":\"")
                .append(loginName).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
