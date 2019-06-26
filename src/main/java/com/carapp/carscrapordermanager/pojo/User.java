package com.carapp.carscrapordermanager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "User得实体，----》",reference = "我是参考")
public class User {

    @Id
    private Integer id;


    @ApiParam(value = "登录名")
    @NotNull(message = "登录名不能为空",groups = {User.Add.class,User.Update.class})
    @Size(min=5, max=18,message = "登录名最小长度5，最大长度18")
    private String loginName;

    @ApiParam(value = "真实姓名"/*,required = true*/)
    private String realName;

    @ApiParam(value = "密码")
    @JsonIgnore
    @NotNull(message = "密码不能为空",groups = {User.Add.class})
    private String password;

    @ApiParam(value = "用户密码加密盐,不用输入系统随机生成",hidden = true)
    @JsonIgnore
    private String passwordSalt;


    @ApiParam(value = "用户状态(1:正常 2:删除 3:禁用),默认：'正常'")
    private String status="1";

    @ApiModelProperty(value = "出生日期")
   // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  //
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date birthDay;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public interface Add{}
    public interface Update{}
}
