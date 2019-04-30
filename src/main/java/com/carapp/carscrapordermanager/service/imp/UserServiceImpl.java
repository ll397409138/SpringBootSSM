

package com.carapp.carscrapordermanager.service.imp;

import com.carapp.carscrapordermanager.mapper.UserMapper;
import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.service.UserService;
import com.carapp.carscrapordermanager.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService  {



    @Resource
    private UserMapper userMapper;

    public int insert(UserVO user){
         Integer roleId = user.getRoleId();

         //判断roleId对应的数据是否存在
         return 1;
    }

    public int update(UserVO user){

        return 1;
    }


}
