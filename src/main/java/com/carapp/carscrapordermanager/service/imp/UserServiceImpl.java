package com.carapp.carscrapordermanager.service.imp;

import com.carapp.carscrapordermanager.mapper.UserMapper;
import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService  {

    @Resource
    private UserMapper userMapper;


}
