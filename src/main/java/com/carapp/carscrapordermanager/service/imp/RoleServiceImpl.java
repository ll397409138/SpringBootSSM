package com.carapp.carscrapordermanager.service.imp;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carapp.carscrapordermanager.config.RoleMapper;
import com.carapp.carscrapordermanager.pojo.Role;
import com.carapp.carscrapordermanager.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Resource
	private RoleMapper  roleMapper;

}
