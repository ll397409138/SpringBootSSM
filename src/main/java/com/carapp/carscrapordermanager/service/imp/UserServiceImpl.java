

package com.carapp.carscrapordermanager.service.imp;

import com.carapp.carscrapordermanager.mapper.UserMapper;
import com.carapp.carscrapordermanager.pojo.Role;
import com.carapp.carscrapordermanager.pojo.User;
import com.carapp.carscrapordermanager.pojo.UserRole;
import com.carapp.carscrapordermanager.service.RoleService;
import com.carapp.carscrapordermanager.service.UserRoleService;
import com.carapp.carscrapordermanager.service.UserService;
import com.carapp.carscrapordermanager.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService  {


    @Autowired
    private  RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Resource
    private UserMapper userMapper;

    public int insert(UserVO user){
        User model = new User();
        BeanUtils.copyProperties(user,model);
        super.insert(model);
         Integer roleId = user.getRoleId();
         //判断roleId对应的数据是否存在
         if(roleId!=null){
             Role role = new Role();
             role.setId(roleId);
             role = roleService.selectByPrimaryKey(role);
             if(role!=null){
                 UserRole ur = new UserRole();
                 ur.setRoleId(roleId);
                 ur.setUserId(model.getId());
                 userRoleService.insert(ur);

             }

         }
         return 1;
    }

    public int updateByPrimaryKey(UserVO user){

        return 1;
    }


}
