package com.carapp.carscrapordermanager.vo;

import com.carapp.carscrapordermanager.pojo.User;

public class UserVO extends User {

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
