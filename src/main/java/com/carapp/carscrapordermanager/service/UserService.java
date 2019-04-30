package com.carapp.carscrapordermanager.service;

import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.vo.UserVO;

public interface UserService extends BaseService<User> {



    int insert(UserVO user);

    int update(UserVO user);
}
