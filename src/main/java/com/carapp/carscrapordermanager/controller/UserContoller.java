package com.carapp.carscrapordermanager.controller;


import com.carapp.carscrapordermanager.common.PageResult;
import com.carapp.carscrapordermanager.common.ResultBean;
import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.service.UserService;
import com.carapp.carscrapordermanager.vo.UserVO;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
@Api(value = "User-API",tags={"用户管理相关接口"})
public class UserContoller {

    @Autowired
    private UserService userService;
    
    
    
    
    public ResultBean<PageResult> getAdvertisementList(
    @ApiParam(name = "page", value = "分页参数页码",required = true)
	@RequestParam(value="page",required = true,defaultValue="1")Integer page,
	@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
	@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
	User paramter) throws Exception{
    	PageResult<User> pageResult = new PageResult<User>();
    	PageInfo<User> pageInfo = userService.queryPageListByWhere(paramter,new RowBounds(page,rows));
    	pageResult.setTotal(pageInfo.getTotal());
    	pageResult.setRows(pageInfo.getList());
    	 return new ResultBean(pageResult);
    }
    

  @RequestMapping(method = RequestMethod.POST)
  @ApiOperation(value = "新增用户接口",notes = "新增用户接口")
  public ResultBean<Boolean> addUser(UserVO user){

      System.out.print(user.getBirthDay());

      return new ResultBean(userService.insert(user)==1);
  }

   @DeleteMapping(value="/{id}")
   @ApiOperation(value = "根据Id删除用户接口",notes = "根据Id删除用户接口")
   public ResultBean<Boolean> removeUser(@PathVariable("id") Integer id){

         User user = new User();
         user.setId(id);

        return new ResultBean(userService.deleteByPrimaryKey(user));
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "根据Id修改用户接口",notes = "根据Id修改用户接口" ,produces="application/json")
    public ResultBean<Boolean> updateUser(@PathVariable("id") Long id,@RequestBody  UserVO user){

        return new ResultBean(userService.updateByPrimaryKey(user)==1);
    }


    @GetMapping(value="{id}")
    @ApiOperation(value = "根据Id查询用户接口",notes = "根据Id查询用户接口")
    public ResultBean<User> getUserById(@PathVariable("id") Integer id){

         User u = new User();
         u.setId(id);
        return new ResultBean(userService.selectByPrimaryKey(u));
    }
}
