package com.carapp.carscrapordermanager.service.imp;



import com.carapp.carscrapordermanager.mapper.UserRoleMapper;
import com.carapp.carscrapordermanager.pojo.UserRole;
import com.carapp.carscrapordermanager.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements
		UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;


}
