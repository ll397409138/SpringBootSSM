package com.carapp.carscrapordermanager.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Id;

@ApiModel(value = "Role得实体，----》",reference = "我是参考")
@Validated
public class Role {
	
	@Id
	private Integer id;
	
	@ApiParam(value = "角色名称",required = true)
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	
	@ApiParam(value = "角色名称",hidden=true)
	@ApiModelProperty(value = "角色状态")
	private String status;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
