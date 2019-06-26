package com.carapp.carscrapordermanager.controller;


import com.carapp.carscrapordermanager.common.ResultBean;
import com.carapp.carscrapordermanager.vo.OrderVO;
import com.carapp.carscrapordermanager.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/order")
@Api(value = "Order-API",tags={"订单管理相关接口"})
public class OrderController {

    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason = "server error")
    @ApiOperation(value = "新增用户接口",notes = "新增用户接口")
    public ResultBean<Boolean> addOrder(@Validated OrderVO order){




        return new ResultBean(true);
    }

    @PutMapping(value="/{id}")
    @ApiOperation(value = "根据Id修改用户接口",notes = "根据Id修改用户接口" ,produces="application/json")
    public ResultBean<Boolean> updateOrder(@PathVariable("id") Long id, @Validated @RequestBody OrderVO user){

        System.out.println(user.toString());
        return new ResultBean(true);
    }
}
