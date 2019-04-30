package com.carapp.carscrapordermanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carapp.carscrapordermanager.common.ResultBean;
import com.carapp.carscrapordermanager.pojo.Role;
import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.service.RoleService;

@RestController
@RequestMapping(value="/role")
@Api(value = "Role-API",tags={"用户角色相关接口"})
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	 @RequestMapping(method = RequestMethod.POST)
	  @ApiOperation(value = "新增用户角色接口",notes = "新增用户角色接口")
	  public ResultBean<Boolean> addRole(Role role){

	   

	      return new ResultBean(roleService.insert(role)==1);
	  }

	   @DeleteMapping(value="/{id}")
	   @ApiOperation(value = "根据Id删除用户角色接口",notes = "根据Id删除用户角色接口")
	   public ResultBean<Boolean> removeRole(@PathVariable("id") Integer id){

	         Role role = new Role();
	         role.setId(id);

	        return new ResultBean(roleService.deleteByPrimaryKey(role));
	    }

	    @PutMapping(value="/{id}")
	    @ApiOperation(value = "根据Id修改用户角色接口",notes = "根据Id修改用户角色接口" )
	    public ResultBean<Boolean> updateRole(@PathVariable("id") Long id,Role role){

	        return new ResultBean(roleService.updateByPrimaryKey(role)==1);
	    }


	    @GetMapping(value="{id}")
	    @ApiOperation(value = "根据Id查询用户接口",notes = "根据Id查询用户接口")
	    public ResultBean<User> getRoleById(@PathVariable("id") Integer id){

	         Role role = new Role();
	         role.setId(id);
	        return new ResultBean(roleService.selectByPrimaryKey(role));
	    }
	
	
	
	

}
